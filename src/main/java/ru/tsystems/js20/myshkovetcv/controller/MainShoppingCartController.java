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
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

@Controller
@RequestMapping("/")
public class MainShoppingCartController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/removeFromCart"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String addToCart(@RequestParam Long productId) {
        Product product = productService.findById(productId);

        shoppingCart.removeProductFromCart(product);

        return "";
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {

        model.addAttribute("productMap", shoppingCart.getProductMap());
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("totalPrice", shoppingCart.getProductTotalPrice());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Shopping cart");
        return "MainShoppingCartPage";
    }

    @RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
    public String showCheckoutPage(ModelMap model) {

        model.addAttribute("productMap", shoppingCart.getProductMap());
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Checkout");
        return "MainCheckoutPage";
    }

}
