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

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        model.addAttribute("title", "List of products");
        return "AdminProductList";
    }

    @RequestMapping(value = {"/products/createnew"}, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "New product");
        return "AdminProductPage";
    }

    @RequestMapping(value = {"/products/createnew"}, method = RequestMethod.POST)
    public String saveProductRedirect(Product product, BindingResult result, ModelMap model) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = {"/products/edit-{id}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Edit product");
        return "AdminProductPage";
    }

    @RequestMapping(value = {"/products/edit-{id}"}, method = RequestMethod.POST)
    public String updateProduct(Product product, BindingResult result, ModelMap model, @PathVariable Long id) {
        productService.updateProduct(product);
        return "redirect:/admin/products";
    }

}
