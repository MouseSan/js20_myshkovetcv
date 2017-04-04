package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    /**
     * This method will list all existing products.
     */
    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);
        return "adminproductlist";
    }

}
