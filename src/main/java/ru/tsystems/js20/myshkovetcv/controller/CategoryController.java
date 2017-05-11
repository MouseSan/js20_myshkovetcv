package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.validators.CategoryDtoValidator;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryDtoValidator categoryDtoValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(categoryDtoValidator);
    }

    @RequestMapping(value = {"/categories/"}, method = RequestMethod.GET)
    public String listCategories(ModelMap model) {
        model.addAllAttributes(categoryService.getCategoryListModel());
        return "categoryList";
    }

    @RequestMapping(value = {"/categories/create"}, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
        model.addAllAttributes(categoryService.getCategoryModel());
        return "categoryEdit";
    }

    @RequestMapping(value = {"/categories/create"}, method = RequestMethod.POST)
    public String saveCategory(@Validated CategoryDto categoryDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(categoryService.getCategoryModel());
            return "categoryEdit";
        }

        categoryService.saveCategory(categoryDto);
        return "redirect:/admin/categories/";
    }

    @RequestMapping(value = "/categories/edit-{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable Long id, ModelMap model) {
        model.addAllAttributes(categoryService.getCategoryModelById(id));
        return "categoryEdit";
    }

    @RequestMapping(value = "/categories/edit-{id}", method = RequestMethod.POST)
    public String updateCategory(@Validated CategoryDto categoryDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(categoryService.getCategoryModel());
            return "categoryEdit";
        }

        categoryService.updateCategory(categoryDto);
        return "redirect:/admin/categories/";
    }
}
