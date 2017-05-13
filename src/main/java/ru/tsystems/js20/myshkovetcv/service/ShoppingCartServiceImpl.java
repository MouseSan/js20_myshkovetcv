package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    @Override
    public void addProductToMap(Long productId) {
        ProductDto productDto = new ProductDto(productService.findById(productId));
        if (productMap.containsKey(productDto)) {
            Integer productQuantity = productMap.get(productDto);
            productMap.put(productDto, ++productQuantity);
        } else {
            productMap.put(productDto, 1);
        }
    }

    @Override
    public Integer getProductQuantityInCart() {
        Integer quantityInCart = 0;
        for (int value : productMap.values()) {
            quantityInCart += value;
        }
        return quantityInCart;
    }

    @Override
    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    @Override
    public void removeProductFromCart(Long productId) {
        updateProductsInCart();
        ProductDto productDto = new ProductDto(productService.findById(productId));
        if (productMap.containsKey(productDto)) {
            productMap.remove(productDto);
        }
    }

    @Override
    public void removeOneProductFromCart(Long productId) {
        updateProductsInCart();
        ProductDto productDto = new ProductDto(productService.findById(productId));
        if (productMap.containsKey(productDto)) {
            Integer quantityInCart = productMap.get(productDto);
            if (quantityInCart > 1) {
                productMap.put(productDto, --quantityInCart);
            } else if (quantityInCart == 1) {
                productMap.remove(productDto);
            }
        }
    }

    @Override
    public Double getProductTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            totalPrice += (double) entry.getValue() * entry.getKey().getPrice();
        }
        return (double) Math.round(totalPrice * 100.0) / 100.0;
    }

    @Override
    @Transactional
    public boolean checkAvailability() {
        boolean allProductsAvailable = true;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            ProductDto productDto = new ProductDto(productService.findById(entry.getKey().getId()));
            if (productDto.getStock() < entry.getValue()) {
                allProductsAvailable = false;
            }
        }
        updateProductsInCart();
        return allProductsAvailable;
    }

    public void updateProductsInCart() {
        Map<ProductDto, Integer> tempMap = new HashMap<>();
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            ProductDto productDto = new ProductDto(productService.findById(entry.getKey().getId()));
            tempMap.put(productDto, entry.getValue());
        }
        productMap.clear();
        productMap = tempMap;
    }

    @Override
    public ModelMap getShoppingCartModel() {
        ModelMap model = new ModelMap();
        if(checkAvailability()) {
            model.addAttribute("notEnoughQuantity", false);
        } else {
            model.addAttribute("notEnoughQuantity", true);
        }
        model.addAttribute("quantityInCart", getProductQuantityInCart());
        model.addAttribute("totalPrice", getProductTotalPrice());
        model.addAttribute("productMap", getProductMap());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        return model;
    }

    @Override
    public void removeAllProductFromCart() {
        productMap.clear();
    }

}
