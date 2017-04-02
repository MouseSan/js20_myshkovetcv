package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class CategoryIdToCategoryClassConverter implements Converter<Object, Category> {

    @Autowired
    CategoryService categoryService;

    /**
     * Gets UserProfile by Id
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Category convert(Object element) {
        if (element instanceof Category) {
            return (Category) element;
        } else {
            Long id = Long.parseLong((String) element);
            Category category = categoryService.findById(id);
            return category;
        }
    }
}
