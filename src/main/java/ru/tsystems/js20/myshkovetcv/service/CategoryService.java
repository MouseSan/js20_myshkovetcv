package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    Category findByName(String name);

    void saveCategory(CategoryDto categoryDto);

    boolean updateCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategoriesDto();

    ModelMap getCategoryListModel();

    ModelMap getCategoryModel();

    ModelMap getCategoryModelById(Long id);

    boolean categoryNotUnique(String categoryName);

    CategoryDto findDtoById(Long categoryId);

    CategoryDto findDtoByName(String categoryName);
}
