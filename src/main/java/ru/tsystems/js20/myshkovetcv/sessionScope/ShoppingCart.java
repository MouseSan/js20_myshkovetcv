package ru.tsystems.js20.myshkovetcv.sessionScope;

import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.Map;

public interface ShoppingCart {

    void addProductToMap(Product product);

    Integer getProductQuantityInCart();

    Map<Product, Integer> getProductMap();

    void removeProductFromCart(Product product);

    Double getProductTotalPrice();

    boolean checkAvailability();

    void removeAllProductFromCart();

    void updateProductsInCart();
}
