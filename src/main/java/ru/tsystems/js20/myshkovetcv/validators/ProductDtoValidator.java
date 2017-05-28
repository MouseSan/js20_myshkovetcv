package ru.tsystems.js20.myshkovetcv.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.service.ProductService;

@Component
public class ProductDtoValidator implements Validator {

    @Autowired
    private ProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty.productDto.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "empty.productDto.description");

        String name = productDto.getName();
        Double price = productDto.getPrice();
        Double weight = productDto.getWeight();
        Double volume = productDto.getVolume();

        if (price == null || price <= 0) {
            errors.rejectValue("price", "empty.productDto.price", "Price must be above zero.");
        }
        if (weight == null || weight <= 0) {
            errors.rejectValue("weight", "empty.productDto.weight", "Weight must be above zero.");
        }
        if (volume == null || volume <= 0) {
            errors.rejectValue("volume", "empty.productDto.volume", "Volume must be above zero.");
        }
        Double stock = productDto.getStock();
        if (stock == null || stock < 0) {
            errors.rejectValue("stock", "empty.productDto.stock", "Stock must be above zero or equal.");
        }
        MultipartFile file = productDto.getMultipartFile();
        if (file != null && !file.getOriginalFilename().isEmpty() && !file.getContentType().equals("image/png")) {
            errors.rejectValue("multipartFile", "wrong.encoding", "File must be in PNG format.");
        }

        if (name != null && !name.isEmpty() && weight != null && volume != null) {
            ProductDto existingProduct = productService.findByProductDto(productDto);
            if (existingProduct != null) {
                Long id = productDto.getId();
                StringBuilder sbSetOfParameters = new StringBuilder();
                sbSetOfParameters.append("Name: ").append(name)
                        .append(". Category: ").append(productDto.getCategoryDto().getName())
                        .append(". Weight: ").append(weight)
                        .append(". Volume: ").append(volume)
                        .append(". Brand: ").append(productDto.getBrandDto().getName())
                        .append(". Backlight: ").append(productDto.isBacklight())
                        .append(". Clock face: ").append(productDto.getClockFace())
                        .append(". Glass: ").append(productDto.getGlass())
                        .append(". Gender: ").append(productDto.getGender())
                        .append(". Water resistant: ").append(productDto.getWaterResistant());
                String setOfParameters = sbSetOfParameters.toString();

                if (id == null) {
                    errors.rejectValue("name", "non.unique.product",
                            new Object[]{setOfParameters},
                            "Product with such a set of parameters alredy exist. {0}");
                } else if (!id.equals(existingProduct.getId())) {
                    errors.rejectValue("name", "non.unique.product",
                            new Object[]{setOfParameters},
                            "Product with such a set of parameters alredy exist. {0}");
                }
            }
        }
    }
}
