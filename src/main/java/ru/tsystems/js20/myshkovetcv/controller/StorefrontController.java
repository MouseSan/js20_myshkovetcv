package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StorefrontController {

//    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.GET)
//    public String getStorefrontSettings(ModelMap model) {
//        model.addAllAttributes(productService.getProductModel());
//        return "productEdit";
//    }
//
//    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.POST)
//    public String saveProduct(StorefrontSettingsDto storefrontSettingsDto, BindingResult result,
//                              ModelMap model) {
//        if (result.hasErrors()) {
//            model.mergeAttributes(productService.getProductModel());
//            return "productEdit";
//        }
//
//        productService.saveProduct(productDto);
//        return "redirect:/admin/products/";
//    }


}
