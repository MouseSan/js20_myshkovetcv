package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Brand;

import java.util.List;

public interface BrandDao {

    Brand findById(Long id);

    Brand findByName(String name);

    void save(Brand brand);

    void updateBrand(Brand brand);

    List<Brand> findAllBrands();

}
