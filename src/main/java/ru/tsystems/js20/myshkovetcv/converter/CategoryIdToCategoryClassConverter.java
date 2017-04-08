package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

@Component
public class CategoryIdToCategoryClassConverter implements Converter<Object, Category> {

    @Autowired
    CategoryService categoryService;

    public Category convert(Object obj) {
        if (obj instanceof Category) {
            return (Category) obj;
        } else {
            Long id = Long.parseLong((String) obj);
            Category category = categoryService.findById(id);
            return category;
        }
    }
}
