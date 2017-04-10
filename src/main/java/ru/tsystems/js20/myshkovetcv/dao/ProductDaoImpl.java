package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Long, Product> implements ProductDao {

    @Override
    public Product findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Product findByName(String name) {
        try {
            Product product = (Product) getEntityManager()
                    .createQuery("SELECT p FROM Product p WHERE p.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();

            return product;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    public void updateProduct(Product product) {
        update(product);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> productList = getEntityManager()
                .createQuery("SELECT p FROM Product p ORDER BY p.name ASC")
                .getResultList();
        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        List<Product> productList = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.category = :category")
                .setParameter("category", category)
                .getResultList();

        return productList;
    }
}
