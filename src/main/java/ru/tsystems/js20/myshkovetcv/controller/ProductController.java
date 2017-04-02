package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    /**
     * This method will list all existing products.
     */
    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "productlist";
    }

    /**
     * This method will provide the medium to add a new products.
     */
    @RequestMapping(value = {"/newproduct"}, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategories());
        return "newproduct";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newproduct"}, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result, ModelMap model) {
        productService.saveProduct(product);

        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "productlist";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-product-{id}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategories());
        return "newproduct";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-product-{id}"}, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result, ModelMap model, @PathVariable Long id) {
        productService.updateProduct(product);
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "productlist";
    }

}
