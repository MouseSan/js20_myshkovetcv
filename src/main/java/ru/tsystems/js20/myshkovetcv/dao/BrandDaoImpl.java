package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Brand;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("brandDao")
public class BrandDaoImpl extends AbstractDao<Long, Brand> implements BrandDao {

    @Override
    public Brand findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Brand findByName(String name) {
        try {
            Brand brand = (Brand) getEntityManager()
                    .createQuery("SELECT b FROM Brand b WHERE b.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return brand;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Brand brand) {
        persist(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        update(brand);
    }

    @Override
    public List<Brand> findAllBrands() {
        List<Brand> brandList = getEntityManager()
                .createQuery("SELECT b FROM Brand b ORDER BY b.name ASC")
                .getResultList();
        return brandList;
    }
}
