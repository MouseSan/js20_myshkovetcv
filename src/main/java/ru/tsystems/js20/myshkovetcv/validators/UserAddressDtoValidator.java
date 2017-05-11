package ru.tsystems.js20.myshkovetcv.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.tsystems.js20.myshkovetcv.dto.UserAddressDto;

@Component
public class UserAddressDtoValidator implements Validator {
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
    }
}
