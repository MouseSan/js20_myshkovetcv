package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.js20.myshkovetcv.service.ProductService;

@Controller
@RequestMapping("/")
public class CatalogController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public Object listProductsByFilter(
            @PathVariable Long categoryId,
            @RequestParam(value = "sorting", required = false) String sorting,
            @RequestParam(value = "brandDto", required = false) String brandDto,
            @RequestParam(value = "clockFace", required = false) String clockFace,
            @RequestParam(value = "glass", required = false) String glass,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "waterResistant", required = false) String waterResistant,
            @RequestParam(value = "backlight", required = false) String backlight,
            ModelMap model) throws NotFoundException {
        model.addAllAttributes(productService.getProductModelByCategoryWithFilter(categoryId, sorting, brandDto, clockFace, glass, gender, waterResistant, backlight));
        logger.info("Getting catalog page with filters");
        return "productListByCategory";
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Object getProductPage(@PathVariable Long productId, ModelMap model) {
        model.addAllAttributes(productService.getProductModelById(productId));
        logger.info("Getting single product page");
        return "productPage";
    }
}
