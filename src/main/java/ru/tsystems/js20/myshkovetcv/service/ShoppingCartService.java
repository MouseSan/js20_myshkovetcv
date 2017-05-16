package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;

import java.util.Map;

public interface ShoppingCartService {

    void addProductToMap(Long productId);

    Integer getProductQuantityInCart();

    Map<ProductDto, Integer> getProductMap();

    void removeProductFromCart(Long productId);

    void removeOneProductFromCart(Long productId);

    Double getProductTotalPrice();

    boolean allProductsAvailable();

    void removeAllProductFromCart();

    void updateProductsInCart();

    ModelMap getShoppingCartModel();

    void copyProductsFromOrder(Long orderId);
}
