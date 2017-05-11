package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Brand;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    Product findByName(String name);

    void save(Product product);

    void updateProduct(Product product);

    List<Product> findAllProducts();

    List<Product> getProductsByCategory(Category category);

    Product findByParameters(String name, Category category, Double weight, Double volume,
                             Brand brand, boolean backlight, ClockFaceType clockFace,
                             ClockGlassType glass, GenderType gender,
                             WaterResistantType waterResistant);
}
