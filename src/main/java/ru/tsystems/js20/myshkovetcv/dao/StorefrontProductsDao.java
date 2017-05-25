package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.StorefrontProducts;

import java.util.List;

public interface StorefrontProductsDao {

    List<StorefrontProducts> findByProduct(Product product);

    List<StorefrontProducts> getAllStorefrontProducts();

    void save(StorefrontProducts storefrontProducts);
}
