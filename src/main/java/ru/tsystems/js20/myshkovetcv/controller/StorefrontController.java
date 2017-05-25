package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.StorefrontSettingsDto;
import ru.tsystems.js20.myshkovetcv.service.StorefrontSettingsService;

@Controller
@RequestMapping("/")
public class StorefrontController {

    @Autowired
    private StorefrontSettingsService storefrontSettingsService;

    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.GET)
    public String getStorefrontSettings(ModelMap model) {
        model.addAllAttributes(storefrontSettingsService.getStorefrontSettingsModel());
        return "storeFrontSettings";
    }

    @RequestMapping(value = {"/admin/storefront/"}, method = RequestMethod.POST)
    public String saveStorefrontSettings(StorefrontSettingsDto storefrontSettingsDto, BindingResult result,
                                         ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(storefrontSettingsService.getStorefrontSettingsModel());
            return "storeFrontSettings";
        }

        storefrontSettingsService.updateStorefrontSettings(storefrontSettingsDto);
        return "redirect:/admin/storefront/?saved";
    }
}
