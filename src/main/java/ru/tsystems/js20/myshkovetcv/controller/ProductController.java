package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.service.ProductService;
import ru.tsystems.js20.myshkovetcv.service.WebService;
import ru.tsystems.js20.myshkovetcv.validators.ProductDtoValidator;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDtoValidator productDtoValidator;
    @Autowired
    private WebService webService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(productDtoValidator);
    }

    @RequestMapping(value = {"/admin/products/"}, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
        model.addAllAttributes(productService.getProductListModel());
        return "productList";
    }

    @RequestMapping(value = {"/admin/products/create"}, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        model.addAllAttributes(productService.getProductModel());
        return "productEdit";
    }

    @RequestMapping(value = {"/admin/products/create"}, method = RequestMethod.POST)
    public String saveProduct(@Validated ProductDto productDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(productService.getProductModel());
            return "productEdit";
        }

        productService.saveProduct(productDto);
        return "redirect:/admin/products/";
    }

    @RequestMapping(value = {"/admin/products/edit-{id}"}, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        model.addAllAttributes(productService.getProductModelById(id));
        return "productEdit";
    }

    @RequestMapping(value = {"/admin/products/edit-{id}"}, method = RequestMethod.POST)
    public String updateProduct(@Validated ProductDto productDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(productService.getProductModel());
            return "productEdit";
        }

        productService.updateProduct(productDto);
        return "redirect:/admin/products/";
    }

    @ResponseBody
    @RequestMapping(value = "/getTopProductsList", method = RequestMethod.GET)
    public List<ProductDto> getTopSoldProductsList(){
        return webService.getProducts();
    }
}
