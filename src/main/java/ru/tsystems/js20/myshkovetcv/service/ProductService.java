package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    Product findByName(String name);

    void saveProduct(ProductDto productDto);

    boolean updateProduct(ProductDto productDto);

    List<Product> findAllProducts();

    List<Product> findProductsByCategory(Category category);

    ModelMap getProductListModel();

    ModelMap getProductModel();

    ModelMap getProductModelById(Long id);

    ModelMap getProductModelByCategory(String categoryName);

    List<ProductDto> getAllProductsDto();

    List<ProductDto> getAllProductsDtoByCategory(CategoryDto categoryDto);

    ProductDto findByProductDto(ProductDto productDto);

    ModelMap getProductModelByCategoryWithFilter(CategoryDto category, BrandDto brandDto,
                                                 boolean backlight, ClockFaceType clockFace,
                                                 ClockGlassType glass, GenderType gender,
                                                 WaterResistantType waterResistant);
}
