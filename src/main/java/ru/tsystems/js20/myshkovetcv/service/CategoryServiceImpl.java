package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.CategoryDao;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private NavBarService navBarService;

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public void saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryDao.save(category);
    }

    @Override
    public boolean updateCategory(CategoryDto categoryDto) {
        Category category = findById(categoryDto.getId());
        if (category != null) {
            category.setName(categoryDto.getName());
            categoryDao.updateCategory(category);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CategoryDto> getAllCategoriesDto() {
        List<Category> categoryList = categoryDao.findAllCategories();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(new CategoryDto(category));
        }
        return categoryDtoList;
    }

    @Override
    public ModelMap getCategoryListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        return modelMap;
    }

    @Override
    public ModelMap getCategoryModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("categoryDto", new CategoryDto());
        return modelMap;
    }

    @Override
    public ModelMap getCategoryModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("categoryDto", new CategoryDto(findById(id)));
        return modelMap;
    }

    @Override
    public boolean categoryNotUnique(String categoryName) {
        Category category = findByName(categoryName);
        return category != null;
    }

    @Override
    public CategoryDto findDtoById(Long categoryId) {
        return new CategoryDto(findById(categoryId));
    }

    @Override
    public CategoryDto findDtoByName(String categoryName) {
        return new CategoryDto(findByName(categoryName));
    }
}
