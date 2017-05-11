package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;

import java.util.List;

public interface BrandService {

    Brand findById(Long id);

    Brand findByName(String name);

    void saveBrand(BrandDto brandDto);

    boolean updateBrand(BrandDto brandDto);

    List<BrandDto> getAllBrandDto();

    boolean brandNotUnique(String brandName);

    BrandDto findDtoById(Long brandId);

    ModelMap getBrandListModel();

    ModelMap getBrandModel();

    ModelMap getBrandModelById(Long id);
}
