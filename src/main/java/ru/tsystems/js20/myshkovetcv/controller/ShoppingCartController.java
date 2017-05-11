package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.ProductService;
import ru.tsystems.js20.myshkovetcv.service.ShoppingCartService;

@Controller
@RequestMapping("/")
public class ShoppingCartController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/addToCart"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String addToCart(@RequestParam Long productId) {
        Product product = productService.findById(productId);

        shoppingCartService.addProductToMap(product);

        return "";
    }

    @RequestMapping(value = {"/removeFromCart"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String removeFromCart(@RequestParam Long productId) {
        Product product = productService.findById(productId);

        shoppingCartService.removeProductFromCart(product);

        return "";
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        if(!shoppingCartService.checkAvailability()) {
            model.addAttribute("enoughquantity", false);
        }
        model.addAttribute("productMap", shoppingCartService.getProductMap());
        model.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        model.addAttribute("totalPrice", shoppingCartService.getProductTotalPrice());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        model.addAttribute("title", "Shopping cart");
        return "MainShoppingCartPage";
    }

}
