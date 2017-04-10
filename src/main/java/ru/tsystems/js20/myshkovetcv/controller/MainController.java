package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {

        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Home page");
        return "MainHomePage";
    }
}
