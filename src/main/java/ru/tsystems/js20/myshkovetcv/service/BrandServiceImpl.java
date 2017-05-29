package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Brand findById(Long id) {
        logger.debug("Trying to find brand: {}", id);
        return brandDao.findById(id);
    }

    @Override
    public Brand findByName(String name) {
        logger.debug("Trying to find brand: {}", name);
        return brandDao.findByName(name);
    }

    @Override
    public void saveBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brandDao.save(brand);
        logger.debug("New brand saved: {}", brand.getName());
    }

    @Override
    public boolean updateBrand(BrandDto brandDto) {
        Brand brand = findById(brandDto.getId());
        if (brand != null) {
            brand.setName(brandDto.getName());
            brandDao.updateBrand(brand);
            logger.debug("Brand updated: {}", brand.getId());
            return true;
        } else {
            logger.warn("Brand id not found: {}", brandDto.getId());
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
        logger.debug("List of all BrandDtos selected");
        return brandDtoList;
    }

    @Override
    public boolean brandNotUnique(String brandName) {
        Brand brand = findByName(brandName);
        boolean unique = brand != null;
        logger.debug("Brand name {} is unique: {}", brandName, unique);
        return unique;
    }

    @Override
    public BrandDto findDtoById(Long brandId) {
        logger.debug("Trying to find brandDto: {}", brandId);
        return new BrandDto(findById(brandId));
    }

    @Override
    public ModelMap getBrandListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("brandList", getAllBrandDto());
        logger.debug("All brands list model formed");
        return modelMap;
    }

    @Override
    public ModelMap getBrandModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("brandDto", new BrandDto());
        logger.debug("New brand model formed");
        return modelMap;
    }

    @Override
    public ModelMap getBrandModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("brandDto", new BrandDto(findById(id)));
        logger.debug("Brand ID:{} model formed", id);
        return modelMap;
    }
}
