package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.service.BrandService;
import ru.tsystems.js20.myshkovetcv.validators.BrandDtoValidator;

@Controller
@RequestMapping("/admin")
public class BrandController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandDtoValidator brandDtoValidator;

    Logger logger = LoggerFactory.getLogger(getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(brandDtoValidator);
    }

    @RequestMapping(value = {"/brands/"}, method = RequestMethod.GET)
    public String listBrands(ModelMap model) {
        model.addAllAttributes(brandService.getBrandListModel());
        logger.info("Getting brand list page");
        return "brandList";
    }

    @RequestMapping(value = {"/brands/create"}, method = RequestMethod.GET)
    public String newBrand(ModelMap model) {
        model.addAllAttributes(brandService.getBrandModel());
        logger.info("Getting brand creating page");
        return "brandEdit";
    }

    @RequestMapping(value = {"/brands/create"}, method = RequestMethod.POST)
    public String saveBrand(@Validated BrandDto brandDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(brandService.getBrandModel());
            logger.info("Brand creating page has errors");
            return "brandEdit";
        }

        brandService.saveBrand(brandDto);
        logger.info("Brand creating page - brand {} created", brandDto.getName());
        return "redirect:/admin/brands/";
    }

    @RequestMapping(value = "/brands/edit-{id}", method = RequestMethod.GET)
    public String editBrand(@PathVariable Long id, ModelMap model) {
        model.addAllAttributes(brandService.getBrandModelById(id));
        logger.info("Getting brand ID:{} editing page", id);
        return "brandEdit";
    }

    @RequestMapping(value = "/brands/edit-{id}", method = RequestMethod.POST)
    public String updateBrand(@Validated BrandDto brandDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(brandService.getBrandModel());
            logger.info("Brand editing page has errors");
            return "brandEdit";
        }

        brandService.updateBrand(brandDto);
        logger.info("Brand editing page - brand {} updated", brandDto.getName());
        return "redirect:/admin/brands/";
    }
}
