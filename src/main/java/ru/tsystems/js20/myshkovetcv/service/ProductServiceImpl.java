package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.ProductDao;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.dto.FilterDto;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private NavBarService navBarService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        Category category = categoryService.findById(productDto.getCategoryDto().getId());
        Brand brand = brandService.findById(productDto.getBrandDto().getId());
        if (category != null && brand != null) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setCategory(category);
            product.setWeight(productDto.getWeight());
            product.setVolume(productDto.getVolume());
            product.setStock(productDto.getStock());
            product.setBrand(brand);
            product.setBacklight(productDto.isBacklight());
            product.setClockFace(productDto.getClockFace());
            product.setGlass(productDto.getGlass());
            product.setGender(productDto.getGender());
            product.setWaterResistant(productDto.getWaterResistant());
            product.setDescription(productDto.getDescription());
            productDao.save(product);
        }
    }

    @Override
    public boolean updateProduct(ProductDto productDto) {
        Category category = categoryService.findById(productDto.getCategoryDto().getId());
        Brand brand = brandService.findById(productDto.getBrandDto().getId());
        if (category != null && brand != null) {
            Product product = findById(productDto.getId());
            if (product != null) {
                product.setName(productDto.getName());
                product.setPrice(productDto.getPrice());
                product.setCategory(category);
                product.setWeight(productDto.getWeight());
                product.setVolume(productDto.getVolume());
                product.setStock(productDto.getStock());
                product.setBrand(brand);
                product.setBacklight(productDto.isBacklight());
                product.setClockFace(productDto.getClockFace());
                product.setGlass(productDto.getGlass());
                product.setGender(productDto.getGender());
                product.setWaterResistant(productDto.getWaterResistant());
                product.setDescription(productDto.getDescription());
                productDao.updateProduct(product);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public List<Product> findProductsByCategory(Category category) {
        return productDao.getProductsByCategory(category);
    }

    @Override
    public ModelMap getProductListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("productList", getAllProductsDto());
        return modelMap;
    }

    @Override
    public ModelMap getProductModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("productDto", new ProductDto());
        modelMap.addAttribute("brandList", brandService.getAllBrandDto());
        modelMap.addAttribute("clockFaceList", ClockFaceType.values());
        modelMap.addAttribute("glassList", ClockGlassType.values());
        modelMap.addAttribute("genderList", GenderType.values());
        modelMap.addAttribute("waterResistantList", WaterResistantType.values());
        return modelMap;
    }

    @Override
    public ModelMap getProductModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("productDto", new ProductDto(findById(id)));
        modelMap.addAttribute("brandList", brandService.getAllBrandDto());
        modelMap.addAttribute("clockFaceList", ClockFaceType.values());
        modelMap.addAttribute("glassList", ClockGlassType.values());
        modelMap.addAttribute("genderList", GenderType.values());
        modelMap.addAttribute("waterResistantList", WaterResistantType.values());
        return modelMap;
    }

    @Override
    public ModelMap getProductModelByCategory(String categoryName) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
//        modelMap.addAttribute("productList", getAllProductsDtoByCategory(categoryName));
        modelMap.addAttribute("brandList", brandService.getAllBrandDto());
        modelMap.addAttribute("clockFaceList", ClockFaceType.values());
        modelMap.addAttribute("glassList", ClockGlassType.values());
        modelMap.addAttribute("genderList", GenderType.values());
        modelMap.addAttribute("waterResistantList", WaterResistantType.values());
        return modelMap;
    }

    @Override
    public List<ProductDto> getAllProductsDto() {
        List<Product> productList = productDao.findAllProducts();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(new ProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> getAllProductsDtoByCategory(CategoryDto categoryDto) {
        List<Product> productList = findProductsByCategory(categoryService.findById(categoryDto.getId()));
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(new ProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public ProductDto findByProductDto(ProductDto productDto) {
        String name = productDto.getName();
        Category category = categoryService.findById(productDto.getCategoryDto().getId());
        Double weight = productDto.getWeight();
        Double volume = productDto.getVolume();
        Brand brand = brandService.findById(productDto.getBrandDto().getId());
        boolean backlight = productDto.isBacklight();
        ClockFaceType clockFace = productDto.getClockFace();
        ClockGlassType glass = productDto.getGlass();
        GenderType gender = productDto.getGender();
        WaterResistantType waterResistant = productDto.getWaterResistant();
        Product existingProduct = productDao.findByParameters(name, category, weight, volume, brand, backlight,
                clockFace, glass, gender, waterResistant);

        if (existingProduct != null) {
            return new ProductDto(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public ModelMap getProductModelByCategoryWithFilter(CategoryDto category, BrandDto brandDto, boolean backlight, ClockFaceType clockFace, ClockGlassType glass, GenderType gender, WaterResistantType waterResistant) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("productList", getAllProductsDtoByCategory(category));
        modelMap.addAttribute("brandList", brandService.getAllBrandDto());
        modelMap.addAttribute("clockFaceList", ClockFaceType.values());
        modelMap.addAttribute("glassList", ClockGlassType.values());
        modelMap.addAttribute("genderList", GenderType.values());
        modelMap.addAttribute("waterResistantList", WaterResistantType.values());
        modelMap.addAttribute("filterDto", new FilterDto(brandDto, backlight, clockFace, glass, gender, waterResistant));
        return modelMap;
    }

}
