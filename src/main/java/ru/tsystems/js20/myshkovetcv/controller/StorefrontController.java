package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tsystems.js20.myshkovetcv.dto.StorefrontSettingsDto;
import ru.tsystems.js20.myshkovetcv.service.StorefrontProductsService;
import ru.tsystems.js20.myshkovetcv.service.StorefrontSettingsService;

@Controller
@RequestMapping("/")
public class StorefrontController {

    @Autowired
    private StorefrontSettingsService storefrontSettingsService;
    @Autowired
    private StorefrontProductsService storefrontProductsService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.GET)
    public String getStorefrontSettings(ModelMap model) {
        model.addAllAttributes(storefrontSettingsService.getStorefrontSettingsModel());
        logger.info("Getting storefront settings page");
        return "storeFrontSettings";
    }

    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.POST)
    public String saveStorefrontSettings(StorefrontSettingsDto storefrontSettingsDto, BindingResult result,
                                         ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(storefrontSettingsService.getStorefrontSettingsModel());
            logger.info("Storefront settings page - has errors");
            return "storeFrontSettings";
        }

        storefrontSettingsService.updateStorefrontSettings(storefrontSettingsDto);
        logger.info("Storefront settings page - settings updated");
        return "redirect:/admin/storefront/?saved";
    }

    @RequestMapping(value = {"/admin/addToCustomList"}, method = RequestMethod.GET)
    public @ResponseBody String addProductToCustomList(@RequestParam Long productId) {
        storefrontProductsService.addProductToList(productId);
        logger.info("Add to custom product list ProductID: {}", productId);
        return "";
    }

    @RequestMapping(value = {"/admin/removeFromCustomList"}, method = RequestMethod.GET)
    public @ResponseBody String removeProductFromCustomList(@RequestParam Long productId) {
        storefrontProductsService.removeProductFromList(productId);
        logger.info("Remove from custom product list ProductID: {}", productId);
        return "";
    }
}
