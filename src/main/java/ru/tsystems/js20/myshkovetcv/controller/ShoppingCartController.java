package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tsystems.js20.myshkovetcv.service.ShoppingCartService;

@Controller
@RequestMapping("/")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = {"/addToCart"}, method = RequestMethod.GET)
    public @ResponseBody String addToCart(@RequestParam Long productId) {
        shoppingCartService.addProductToMap(productId);
        return "";
    }

    @RequestMapping(value = {"/removeFromCart"}, method = RequestMethod.GET)
    public @ResponseBody String removeFromCart(@RequestParam Long productId) {
        shoppingCartService.removeProductFromCart(productId);
        return "";
    }

    @RequestMapping(value = {"/removeOneFromCart"}, method = RequestMethod.GET)
    public @ResponseBody String removeOneFromCart(@RequestParam Long productId) {
        shoppingCartService.removeOneProductFromCart(productId);
        return "";
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        model.addAllAttributes(shoppingCartService.getShoppingCartModel());
        return "checkout";
    }
}
