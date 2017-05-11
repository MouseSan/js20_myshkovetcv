package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.dto.FilterDto;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;
import ru.tsystems.js20.myshkovetcv.service.ProductService;

@Controller
@RequestMapping("/")
public class CatalogController {

    @Autowired
    private ProductService productService;

//    @RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
//    public String listAllProductsByCategory(@PathVariable String categoryName, ModelMap model) {
//        model.addAllAttributes(productService.getProductModelByCategory(categoryName));
//        model.addAttribute("filterDto", new FilterDto());
//        return "productListByCategory";
//    }

    @RequestMapping(value = "/category/{categoryName}/filter", method = RequestMethod.GET)
    public String listAllProductsByCategoryWithFilter(@PathVariable String categoryName, FilterDto filterDto, ModelMap model) {
        model.addAllAttributes(productService.getProductModelByCategory(categoryName));
        return "productListByCategory";
    }


    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public Object listAllProductsByCategoryWithFilter(
            @PathVariable CategoryDto category,
            @RequestParam(value = "brandDto", required = false) BrandDto brandDto,
            @RequestParam(value = "backlight", required = false) boolean backlight,
            @RequestParam(value = "clockFace", required = false) ClockFaceType clockFace,
            @RequestParam(value = "glass", required = false) ClockGlassType glass,
            @RequestParam(value = "gender", required = false) GenderType gender,
            @RequestParam(value = "waterResistant", required = false) WaterResistantType waterResistant,
            ModelMap model) throws NotFoundException {
        model.addAllAttributes(productService.getProductModelByCategoryWithFilter(category, brandDto, backlight, clockFace, glass, gender, waterResistant));
        return "productListByCategory";
    }

}
