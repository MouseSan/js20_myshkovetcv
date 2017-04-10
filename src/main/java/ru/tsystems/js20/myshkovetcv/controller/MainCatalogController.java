package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.ProductService;
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainCatalogController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(value = {"/addToCart"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String addToCart(@RequestParam Long productId) {
        Product product = productService.findById(productId);

        shoppingCart.addProductToMap(product);

        return "";
    }

    @RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
    public String listAllProductsByCategory(@PathVariable String categoryName, ModelMap model) {
        Category category = categoryService.findByName(categoryName);
        List<Product> productList = productService.getProductsByCategory(category);

        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("productList", productList);
        model.addAttribute("title", category.getName());
        return "MainProductListByCategory";
    }

}
