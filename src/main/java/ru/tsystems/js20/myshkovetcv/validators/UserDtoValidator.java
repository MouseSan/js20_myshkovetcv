package ru.tsystems.js20.myshkovetcv.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.service.UserService;

import java.util.Date;

@Component
public class UserDtoValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        UserDtoValidationType validationType = userDto.getUserDtoValidationType();

        if (validationType == UserDtoValidationType.Registration) {
            // User name validation
            String userName = userDto.getUserName();
            if (userName == null || userName.trim().isEmpty()) {
                errors.rejectValue("userName", "empty.userDto.userName", "User name can't be blank.");
            } else if (userService.userNameNotUnique(userName)) {
                errors.rejectValue("userName", "non.unique.userName", new Object[]{userName}, "{0} user name alredy in use.");
            }
        }

        if (validationType == UserDtoValidationType.Registration || validationType == UserDtoValidationType.UserGeneralInfo) {
            // First name validation
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "empty.userDto.firstName");

            // E-mail validation
            String email = userDto.getEmailAddress();
            if (email == null || email.trim().isEmpty()) {
                errors.rejectValue("emailAddress", "empty.userDto.emailAddress", "E-mail address can't be blank.");
            } else {
                UserDto currentUser = userService.getCurrentUserDto();
                if (currentUser != null) {
                    if (!currentUser.getEmailAddress().equals(email)) {
                        if (userService.emailAddressNotUnique(email)) {
                            errors.rejectValue("emailAddress", "non.unique.emailAddress", new Object[]{email}, "{0} e-mail address isn't unique.");
                        }
                    }
                } else {
                    if (userService.emailAddressNotUnique(email)) {
                        errors.rejectValue("emailAddress", "non.unique.emailAddress", new Object[]{email}, "{0} e-mail address isn't unique.");
                    }
                }
            }

            // Date of birth validation
            Date dateOfBirth = userDto.getDateOfBirth();
            if (dateOfBirth == null) {
                errors.rejectValue("dateOfBirth", "empty.userDto.dateOfBirth", "Date of birth can't be blank.");
            } else {
                Date minAge = new Date();
                minAge.setYear(minAge.getYear() - 14);
                if (dateOfBirth.after(minAge)) {
                    errors.rejectValue("dateOfBirth", "invalid.userDto.dateOfBirth", "You must be over 14 years old.");
                }
            }
        }

        if (validationType == UserDtoValidationType.Password || validationType == UserDtoValidationType.Registration) {
            // Password validation
            ValidationUtils.rejectIfEmpty(errors, "password", "empty.userDto.password");

            // Password repeat validation
            String passwordRepeat = userDto.getPasswordRepeat();
            String password = userDto.getPassword();
            if (passwordRepeat == null || passwordRepeat.isEmpty()) {
                errors.rejectValue("passwordRepeat", "empty.userDto.passwordRepeat", "Repeat password.");
            } else if (password != null && !password.equals(passwordRepeat)) {
                errors.rejectValue("passwordRepeat", "not.match.password", "Passwords do not match.");
            }
        }
    }
}
