package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Category;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Long, Category> implements CategoryDao {

    @Override
    public Category findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Category findByName(String name) {
        try {
            Category category = (Category) getEntityManager()
                    .createQuery("SELECT c FROM Category c WHERE c.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return category;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Category category) {
        persist(category);
    }

    public void updateCategory(Category category) {
        update(category);
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categoryList = getEntityManager()
                .createQuery("SELECT c FROM Category c ORDER BY c.name ASC")
                .getResultList();
        return categoryList;
    }
}
