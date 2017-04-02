package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    Category findByName(String name);

    void saveCategory(Category category);

    void updateCategory(Category category);

    List<Category> findAllCategories();

}
