package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.Map;

public interface ShoppingCartService {

    void addProductToMap(Product product);

    Integer getProductQuantityInCart();

    Map<Product, Integer> getProductMap();

    void removeProductFromCart(Product product);

    Double getProductTotalPrice();

    boolean checkAvailability();

    void removeAllProductFromCart();

    void updateProductsInCart();
}
