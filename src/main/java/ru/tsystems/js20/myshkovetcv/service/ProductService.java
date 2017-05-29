package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    Product findByName(String name);

    void saveProduct(ProductDto productDto);

    boolean updateProduct(ProductDto productDto);

    ModelMap getProductListModel();

    ModelMap getProductModel();

    ModelMap getProductModelById(Long id);

    List<ProductDto> getAllProductsDto();

    ProductDto findByProductDto(ProductDto productDto);

    ModelMap getProductModelByCategoryWithFilter(Long categoryId, String sorting, String brandName,
                                                 String clockFace,String glass, String gender,
                                                 String waterResistant, String backlight);
}
