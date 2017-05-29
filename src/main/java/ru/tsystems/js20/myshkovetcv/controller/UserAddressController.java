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
import ru.tsystems.js20.myshkovetcv.dto.UserAddressDto;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;
import ru.tsystems.js20.myshkovetcv.validators.UserAddressDtoValidator;

@Controller
@RequestMapping("/")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private UserAddressDtoValidator userAddressDtoValidator;

    Logger logger = LoggerFactory.getLogger(getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userAddressDtoValidator);
    }

    @RequestMapping(value = "/userSettings/createNewAddress", method = RequestMethod.GET)
    public String getCreateUserAddressPage(ModelMap model) {
        model.addAllAttributes(userAddressService.getUserAddressModel());
        logger.info("Getting user address creating page");
        return "userSettingsAddress";
    }

    @RequestMapping(value = "/userSettings/createNewAddress", method = RequestMethod.POST)
    public String createUserAddress(@Validated UserAddressDto userAddressDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(userAddressService.getUserAddressModel());
            logger.info("User address creating page - has errors");
            return "userSettingsAddress";
        }

        userAddressService.saveUserAddress(userAddressDto);
        logger.info("User address creating page - address saved");
        return "redirect:/userSettings/";
    }

    @RequestMapping(value = "/userSettings/editUserAddress-{id}", method = RequestMethod.GET)
    public String editUserAddress(@PathVariable Long id, ModelMap model) {
        if (userAddressService.currentUserHaveAccess(id)) {
            model.addAllAttributes(userAddressService.getUserAddressModelById(id));
            logger.info("Getting user address editing page");
            return "userSettingsAddress";
        } else {
            logger.warn("User address editing page - access denied");
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/userSettings/editUserAddress-{id}", method = RequestMethod.POST)
    public String updateUserAddress(@Validated UserAddressDto userAddressDto, BindingResult result, ModelMap model) {
        if (userAddressService.currentUserHaveAccess(userAddressDto.getId())) {
            if (result.hasErrors()) {
                model.mergeAttributes(userAddressService.getUserAddressModelById(userAddressDto.getId()));
                logger.info("User address editing page - has errors");
                return "userSettingsAddress";
            }

            userAddressService.updateUserAddress(userAddressDto);
            logger.info("User address editing page - address updated");
            return "redirect:/userSettings/";
        } else {
            logger.warn("User address editing page - access denied");
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = {"/userSettings/removeUserAddress-{id}"}, method = RequestMethod.GET)
    public String removeAddress(@PathVariable Long id) {
        if (userAddressService.currentUserHaveAccess(id)) {
            userAddressService.deleteUserAddress(id);
            logger.info("User address editing page - address removed");
            return "redirect:/userSettings/";
        } else {
            logger.warn("User address editing page - access denied");
            return "page403AccessDenied";
        }
    }
}
