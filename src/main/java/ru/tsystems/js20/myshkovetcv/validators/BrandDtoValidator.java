package ru.tsystems.js20.myshkovetcv.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.service.BrandService;

@Component
public class BrandDtoValidator implements Validator {

    @Autowired
    private BrandService brandService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(Class<?> clazz) {
        return BrandDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BrandDto brandDto = (BrandDto) target;
        String brandName = brandDto.getName();
        Long brandId = brandDto.getId();

        if (brandName == null || brandName.trim().isEmpty()) {
            errors.rejectValue("name", "empty.brandDto.name", "Name can't be blank.");
        } else if (brandService.brandNotUnique(brandName)) {
            if (brandId != null && !brandService.findDtoById(brandId).getName().equals(brandName)) {
                errors.rejectValue("name", "non.unique.brandDto.name", new Object[]{brandName}, "{0} category name isn't unique.");
            } else if (brandId == null) {
                errors.rejectValue("name", "non.unique.brandDto.name", new Object[]{brandName}, "{0} category name isn't unique.");
            }
        }

        if (errors.hasErrors()) {
            logger.debug("BrandDto has validation errors");
        } else {
            logger.debug("BrandDto no validation errors");
        }
    }
}
