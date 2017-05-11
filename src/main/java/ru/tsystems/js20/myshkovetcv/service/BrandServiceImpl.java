package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.BrandDao;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;

import java.util.ArrayList;
import java.util.List;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private NavBarService navBarService;

    @Override
    public Brand findById(Long id) {
        return brandDao.findById(id);
    }

    @Override
    public Brand findByName(String name) {
        return brandDao.findByName(name);
    }

    @Override
    public void saveBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brandDao.save(brand);
    }

    @Override
    public boolean updateBrand(BrandDto brandDto) {
        Brand brand = findById(brandDto.getId());
        if (brand != null) {
            brand.setName(brandDto.getName());
            brandDao.updateBrand(brand);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<BrandDto> getAllBrandDto() {
        List<Brand> brandList = brandDao.findAllBrands();
        List<BrandDto> brandDtoList = new ArrayList<>();
        for (Brand brand : brandList) {
            brandDtoList.add(new BrandDto(brand));
        }
        return brandDtoList;
    }

    @Override
    public boolean brandNotUnique(String brandName) {
        Brand brand = findByName(brandName);
        return brand != null;
    }

    @Override
    public BrandDto findDtoById(Long brandId) {
        return new BrandDto(findById(brandId));
    }

    @Override
    public ModelMap getBrandListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("brandList", getAllBrandDto());
        return modelMap;
    }

    @Override
    public ModelMap getBrandModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("brandDto", new BrandDto());
        return modelMap;
    }

    @Override
    public ModelMap getBrandModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("brandDto", new BrandDto(findById(id)));
        return modelMap;
    }
}
