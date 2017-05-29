package ru.tsystems.js20.myshkovetcv.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.tsystems.js20.myshkovetcv.dto.UserAddressDto;

@Component
public class UserAddressDtoValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(Class<?> clazz) {
        return UserAddressDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "empty.userAddressDto.country");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "empty.userAddressDto.city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "empty.userAddressDto.zipCode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "empty.userAddressDto.street");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apartmentNumber", "empty.userAddressDto.apartmentNumber");

        if (errors.hasErrors()) {
            logger.debug("UserAddressDto has validation errors");
        } else {
            logger.debug("UserAddressDto no validation errors");
        }
    }
}
