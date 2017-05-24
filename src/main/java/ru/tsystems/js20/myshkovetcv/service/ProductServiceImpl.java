package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.ProductDao;
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
    @Autowired
    private JmsService jmsService;

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
                jmsService.sendMessage("UPDATE");
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
    public List<ProductDto> getAllProductsDto() {
        List<Product> productList = productDao.findAllProducts();
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
    public ModelMap getProductModelByCategoryWithFilter(Long categoryId, String sorting, String brandId, String clockFace, String glass, String gender, String waterResistant, String backlight) {
        FilterDto filterDto = new FilterDto();

        if (sorting == null) {
            filterDto.setSorting("lowPrice");
        } else if (sorting.equals("lowPrice")) {
            filterDto.setSorting("lowPrice");
        } else if (sorting.equals("highPrice")) {
            filterDto.setSorting("highPrice");
        } else if (sorting.equals("nameAsc")) {
            filterDto.setSorting("nameAsc");
        } else if (sorting.equals("nameDesc")) {
            filterDto.setSorting("nameDesc");
        } else {
            filterDto.setSorting("lowPrice");
        }

        if (brandId == null || brandId.equals("any")) {
            filterDto.setBrandDto(null);
        } else {
            filterDto.setBrandDto(brandService.findDtoById(Long.parseLong(brandId)));
        }
        if (clockFace == null || clockFace.equals("any")) {
            filterDto.setClockFace(null);
        } else {
            filterDto.setClockFace(ClockFaceType.valueOf(clockFace));
        }
        if (glass == null || glass.equals("any")) {
            filterDto.setGlass(null);
        } else {
            filterDto.setGlass(ClockGlassType.valueOf(glass));
        }
        if (gender == null || gender.equals("any")) {
            filterDto.setGender(null);
        } else {
            filterDto.setGender(GenderType.valueOf(gender));
        }
        if (waterResistant == null || waterResistant.equals("any")) {
            filterDto.setWaterResistant(null);
        } else {
            filterDto.setWaterResistant(WaterResistantType.valueOf(waterResistant));
        }
        if (backlight == null) {
            filterDto.setBacklight("any");
        } else if (backlight.equals("true")) {
            filterDto.setBacklight("true");
        } else if (backlight.equals("false")) {
            filterDto.setBacklight("false");
        } else {
            filterDto.setBacklight("any");
        }
        filterDto.setCategoryDto(categoryService.findDtoById(categoryId));

        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("filterDto", filterDto);
        modelMap.addAttribute("productList", getProductsDtoByFilter(filterDto));
        modelMap.addAttribute("brandList", brandService.getAllBrandDto());
        modelMap.addAttribute("clockFaceList", ClockFaceType.values());
        modelMap.addAttribute("glassList", ClockGlassType.values());
        modelMap.addAttribute("genderList", GenderType.values());
        modelMap.addAttribute("waterResistantList", WaterResistantType.values());
        return modelMap;
    }

    private List<ProductDto> getProductsDtoByFilter(FilterDto filterDto) {
        List<Product> productList = productDao.findByFilter(filterDto);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(new ProductDto(product));
        }
        return productDtoList;
    }
}
