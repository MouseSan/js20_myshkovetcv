package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    Product findByName(String name);

    void saveProduct(Product product);

    void updateProduct(Product product);

    List<Product> findAllProducts();

    List<Product> getProductsByCategory(Category category);

}
