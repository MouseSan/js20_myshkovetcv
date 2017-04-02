package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.CategoryDao;
import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        Category entity = categoryDao.findById(category.getId());
        if (entity != null) {
            categoryDao.updateCategory(category);
        }
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAllCategories();
    }
}
