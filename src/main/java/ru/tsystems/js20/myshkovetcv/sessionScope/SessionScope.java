package ru.tsystems.js20.myshkovetcv.sessionScope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.List;

/**
 * Created by Viacheslav on 05.04.2017.
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScope {

    private List<Product> productList;

    private List<Product> productListOnCustomerCart;

    public List<Product> getProductListOnCustomerCart() {
        return productListOnCustomerCart;
    }

    public void setProductListOnCustomerCart(List<Product> productListOnCustomerCart) {
        this.productListOnCustomerCart = productListOnCustomerCart;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
