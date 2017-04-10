package ru.tsystems.js20.myshkovetcv.sessionScope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartImpl implements ShoppingCart {

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
        if (productMap.containsKey(product)) {
            Integer quantityInCart = productMap.get(product);
            if (quantityInCart > 1) {
                productMap.put(product, --quantityInCart);
            } else if (quantityInCart == 1) {
                productMap.remove(product);
            }
        }
    }

}
