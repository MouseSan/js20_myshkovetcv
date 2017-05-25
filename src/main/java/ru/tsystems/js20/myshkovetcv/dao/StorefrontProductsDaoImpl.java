package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.StorefrontProducts;

import java.util.List;

@Repository("storefrontProductsDao")
public class StorefrontProductsDaoImpl extends AbstractDao<Long, StorefrontProducts> implements StorefrontProductsDao {

    @Override
    public List<StorefrontProducts> findByProduct(Product product) {
        List<StorefrontProducts> storefrontProductsList = getEntityManager()
                .createQuery("SELECT s FROM StorefrontProducts s WHERE s.product = :product")
                .setParameter("product", product)
                .getResultList();
        return storefrontProductsList;
    }

    @Override
    public List<StorefrontProducts> getAllStorefrontProducts() {
        List<StorefrontProducts> storefrontProductsList = getEntityManager()
                .createQuery("SELECT s FROM StorefrontProducts s ORDER BY s.id ASC")
                .getResultList();
        return storefrontProductsList;
    }

    @Override
    public void save(StorefrontProducts storefrontProducts) {
        persist(storefrontProducts);
    }
}
