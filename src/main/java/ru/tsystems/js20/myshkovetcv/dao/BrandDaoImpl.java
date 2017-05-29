package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Brand;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("brandDao")
public class BrandDaoImpl extends AbstractDao<Long, Brand> implements BrandDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Brand findById(Long id) {
        logger.debug("Getting brand by id: {}", id);
        return getByKey(id);
    }

    @Override
    public Brand findByName(String name) {
        try {
            Brand brand = (Brand) getEntityManager()
                    .createQuery("SELECT b FROM Brand b WHERE b.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            logger.debug("Brand found by name: {}", name);
            return brand;
        } catch (NoResultException ex) {
            logger.warn("Brand not found by name: {}", name);
            return null;
        }
    }

    @Override
    public void save(Brand brand) {
        persist(brand);
        logger.debug("Brand saved: {}", brand.getName());
    }

    @Override
    public void updateBrand(Brand brand) {
        update(brand);
        logger.debug("Brand updated: {}", brand.getName());
    }

    @Override
    public List<Brand> findAllBrands() {
        List<Brand> brandList = getEntityManager()
                .createQuery("SELECT b FROM Brand b ORDER BY b.name ASC")
                .getResultList();
        logger.debug("Get list of all brands");
        return brandList;
    }
}
