package ru.tsystems.js20.myshkovetcv.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

@Component
public class CategoryConverter implements Converter<Object, CategoryDto> {

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public CategoryDto convert(Object o) {
        if (o instanceof CategoryDto) {
            logger.debug("CategoryDto no need in conversion");
            return (CategoryDto) o;
        } else {
            Long id = Long.parseLong((String) o);
            logger.debug("CategoryDto converted from ID: {}", id);
            return categoryService.findDtoById(id);
        }
    }
}
