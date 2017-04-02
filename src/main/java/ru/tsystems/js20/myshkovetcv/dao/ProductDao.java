package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    Product findByName(String name);

    void save(Product product);

    void updateProduct(Product product);

    List<Product> findAllProducts();

}
