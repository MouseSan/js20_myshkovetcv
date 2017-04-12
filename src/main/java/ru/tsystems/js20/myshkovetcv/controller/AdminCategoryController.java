package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Parameter;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.ParameterService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ParameterService parameterService;

    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public String listCategories(ModelMap model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("title", "List of categories");
        return "AdminCategoryList";
    }

    @RequestMapping(value = {"/categories/createnew"}, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
        Category category = new Category();
        List<Parameter> parameterList = parameterService.findAllParameters();
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("category", category);
        model.addAttribute("title", "New category");
        return "AdminCategoryPage";
    }

    @RequestMapping(value = {"/categories/createnew"}, method = RequestMethod.POST)
    public String saveCategory(Category category, BindingResult result, ModelMap model) {
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/categories/edit-{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable Long id, ModelMap model) {
        Category category = categoryService.findById(id);

        model.addAttribute("category", category);
        model.addAttribute("title", "Edit category");
        return "AdminCategoryPage";
    }

    @RequestMapping(value = "/categories/edit-{id}", method = RequestMethod.POST)
    public String updateCategory(Category category, BindingResult result, ModelMap model, @PathVariable Long id) {
        categoryService.updateCategory(category);
        return "redirect:/admin/categories";
    }

}
