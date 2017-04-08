package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.service.ProductService;
import ru.tsystems.js20.myshkovetcv.sessionScope.SessionScope;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainCatalogController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SessionScope sessionScope;

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public ModelAndView showHomePage(ModelAndView model) {
        productService.addProductToSeesionScope();
        model = new ModelAndView("MainProductList");
        model.addObject("ProductList", sessionScope.getProductList());
        return model;
    }

    @RequestMapping(value = {"/AddTOCard"}, method = RequestMethod.POST)
    @ResponseBody
    public String addToCart(@RequestParam(value = "productIndex") String button,
                            Model model) {
        List<Product> productListOnMyCard = null;
        int numberOfButton = Integer.parseInt(button);
        productListOnMyCard = sessionScope.getProductListOnCustomerCart();
        productListOnMyCard.add(sessionScope.getProductList().get(numberOfButton));
        sessionScope.setProductListOnCustomerCart(productListOnMyCard);
        return "Add to cart";
    }

}
