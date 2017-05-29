package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Category findById(Long id) {
        logger.debug("Trying to find category: {}", id);
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        logger.debug("Trying to find category: {}", name);
        return categoryDao.findByName(name);
    }

    @Override
    public void saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryDao.save(category);
        logger.debug("New category saved: {}", category.getName());
    }

    @Override
    public boolean updateCategory(CategoryDto categoryDto) {
        Category category = findById(categoryDto.getId());
        if (category != null) {
            category.setName(categoryDto.getName());
            categoryDao.updateCategory(category);
            logger.debug("Category updated: {}", category.getId());
            return true;
        } else {
            logger.warn("Category id not found: {}", categoryDto.getId());
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
        logger.debug("List of all CategoryDtos selected");
        return categoryDtoList;
    }

    @Override
    public ModelMap getCategoryListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        logger.debug("All category list model formed");
        return modelMap;
    }

    @Override
    public ModelMap getCategoryModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("categoryDto", new CategoryDto());
        logger.debug("New category model formed");
        return modelMap;
    }

    @Override
    public ModelMap getCategoryModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("categoryDto", new CategoryDto(findById(id)));
        logger.debug("Category ID:{} model formed", id);
        return modelMap;
    }

    @Override
    public boolean categoryNotUnique(String categoryName) {
        Category category = findByName(categoryName);
        boolean unique = category != null;
        logger.debug("Category name {} is unique: {}", categoryName, unique);
        return unique;
    }

    @Override
    public CategoryDto findDtoById(Long categoryId) {
        logger.debug("Trying to find categoryDto: {}", categoryId);
        return new CategoryDto(findById(categoryId));
    }

    @Override
    public CategoryDto findDtoByName(String categoryName) {
        logger.debug("Trying to find categoryDto: {}", categoryName);
        return new CategoryDto(findByName(categoryName));
    }
}
