package ru.tsystems.js20.myshkovetcv.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

@Component
public class CategoryDtoValidator implements Validator {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryDto categoryDto = (CategoryDto) target;
        String categoryName = categoryDto.getName();
        Long categoryId = categoryDto.getId();

        if (categoryName == null || categoryName.trim().isEmpty()) {
            errors.rejectValue("name", "empty.categoryDto.name", "Name can't be blank.");
        } else if (categoryService.categoryNotUnique(categoryName)) {
            if (categoryId != null && !categoryService.findDtoById(categoryId).getName().equals(categoryName)) {
                errors.rejectValue("name", "non.unique.categoryDto.name", new Object[]{categoryName}, "{0} category name isn't unique.");
            } else if (categoryId == null) {
                errors.rejectValue("name", "non.unique.categoryDto.name", new Object[]{categoryName}, "{0} category name isn't unique.");
            }
        }
    }
}
