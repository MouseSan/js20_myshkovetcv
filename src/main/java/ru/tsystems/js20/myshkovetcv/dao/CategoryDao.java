package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.List;

public interface CategoryDao {

    Category findById(Long id);

    Category findByName(String name);

    void save(Category category);

    void updateCategory(Category category);

    List<Category> findAllCategories();

}
