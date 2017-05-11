package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

@Component
public class CategoryConverter implements Converter<Object, CategoryDto> {

    @Autowired
    protected CategoryService categoryService;

    @Override
    public CategoryDto convert(Object o) {
        if (o instanceof CategoryDto) {
            return (CategoryDto) o;
        } else if (o instanceof String) {
            String categoryName = (String) o;
            CategoryDto categoryDto = categoryService.findDtoByName(categoryName);
            return categoryDto;
        } else {
            Long id = Long.parseLong((String) o);
            CategoryDto categoryDto = categoryService.findDtoById(id);
            return categoryDto;
        }
    }
}
