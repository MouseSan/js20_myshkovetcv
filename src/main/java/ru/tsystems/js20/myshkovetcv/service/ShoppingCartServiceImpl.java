package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ProductService productService;

    private Map<Product, Integer> productMap = new HashMap<>();

    @Override
    public void addProductToMap(Product product) {
        if (productMap.containsKey(product)) {
            Integer productQuantity = productMap.get(product);
            productMap.put(product, ++productQuantity);
        } else {
            productMap.put(product, 1);
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
    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    @Override
    public void removeProductFromCart(Product product) {
        updateProductsInCart();
        if (productMap.containsKey(product)) {
            Integer quantityInCart = productMap.get(product);
            if (quantityInCart > 1) {
                productMap.put(product, --quantityInCart);
            } else if (quantityInCart == 1) {
                productMap.remove(product);
            }
        }
    }

    @Override
    public Double getProductTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            totalPrice += (double) entry.getValue() * entry.getKey().getPrice();
        }
        return (double) Math.round(totalPrice * 100.0) / 100.0;
    }

    @Override
    @Transactional
    public boolean checkAvailability() {
        boolean allProductsAvailable = true;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = productService.findById(entry.getKey().getId());
            if (product.getStock() < entry.getValue()) {
                allProductsAvailable = false;
            }
        }
        updateProductsInCart();
        return allProductsAvailable;
    }

    public void updateProductsInCart() {
        Map<Product, Integer> tempMap = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = productService.findById(entry.getKey().getId());
            tempMap.put(product, entry.getValue());
        }
        productMap.clear();
        productMap = tempMap;
    }

    @Override
    public void removeAllProductFromCart() {
        productMap.clear();
    }

}
