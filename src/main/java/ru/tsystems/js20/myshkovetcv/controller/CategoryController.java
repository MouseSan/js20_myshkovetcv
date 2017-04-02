package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * This method will list all existing categories.
     */
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public String listCategories(ModelMap model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "categorylist";
    }

    /**
     * This method will provide the medium to add a new products.
     */
    @RequestMapping(value = {"/newcategory"}, method = RequestMethod.GET)
    public String newCategory(ModelMap model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("edit", false);
        return "newcategory";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newcategory"}, method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult result,
                               ModelMap model) {
        categoryService.saveCategory(category);
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "categorylist";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-category-{id}"}, method = RequestMethod.GET)
    public String editCategory(@PathVariable Long id, ModelMap model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("edit", true);
        return "newcategory";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-category-{id}"}, method = RequestMethod.POST)
    public String updateCategory(@Valid Category category, BindingResult result,
                                 ModelMap model, @PathVariable Long id) {
        categoryService.updateCategory(category);
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "categorylist";
    }

}
