package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CategoryService categoryService;
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    @Override
    @Transactional
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
    @Transactional
    public Integer getProductQuantityInCart() {
        Integer quantityInCart = 0;
        for (int value : productMap.values()) {
            quantityInCart += value;
        }
        return quantityInCart;
    }

    @Override
    @Transactional
    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    @Override
    @Transactional
    public void removeProductFromCart(Long productId) {
        updateProductsInCart();
        ProductDto productDto = new ProductDto(productService.findById(productId));
        if (productMap.containsKey(productDto)) {
            productMap.remove(productDto);
        }
    }

    @Override
    @Transactional
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
    @Transactional
    public Double getProductTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            totalPrice += (double) entry.getValue() * entry.getKey().getPrice();
        }
        return (double) Math.round(totalPrice * 100.0) / 100.0;
    }

    @Override
    @Transactional
    public boolean allProductsAvailable() {
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

    @Override
    @Transactional
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
    @Transactional
    public ModelMap getShoppingCartModel() {
        ModelMap model = new ModelMap();
        if(allProductsAvailable()) {
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
    public void copyProductsFromOrder(Long orderId) {
        Orders orders = ordersService.findById(orderId);
        for (SoldProductInfo soldProductInfo : orders.getSoldProductInfoList()){
            Long productId = soldProductInfo.getProduct().getId();
            Integer soldQuantity = soldProductInfo.getSoldQuantity();

            ProductDto productDto = new ProductDto(productService.findById(productId));
            if (productMap.containsKey(productDto)) {
                Integer productQuantity = productMap.get(productDto) + soldQuantity;
                productMap.put(productDto, productQuantity);
            } else {
                productMap.put(productDto, soldQuantity);
            }
        }
    }

    @Override
    @Transactional
    public void removeAllProductFromCart() {
        productMap.clear();
    }
}
