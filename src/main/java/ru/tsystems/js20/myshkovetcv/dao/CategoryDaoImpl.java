package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Category;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Long, Category> implements CategoryDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Category findById(Long id) {
        logger.debug("Getting category by id: {}", id);
        return getByKey(id);
    }

    @Override
    public Category findByName(String name) {
        try {
            Category category = (Category) getEntityManager()
                    .createQuery("SELECT c FROM Category c WHERE c.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            logger.debug("Category found by name: {}", name);
            return category;
        } catch (NoResultException ex) {
            logger.warn("Category not found by name: {}", name);
            return null;
        }
    }

    @Override
    public void save(Category category) {
        persist(category);
        logger.debug("Category saved: {}", category.getName());
    }

    public void updateCategory(Category category) {
        update(category);
        logger.debug("Category updated: {}", category.getName());
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categoryList = getEntityManager()
                .createQuery("SELECT c FROM Category c ORDER BY c.name ASC")
                .getResultList();
        logger.debug("Get list of all categories");
        return categoryList;
    }
}
