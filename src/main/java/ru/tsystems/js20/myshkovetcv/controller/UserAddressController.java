package ru.tsystems.js20.myshkovetcv.controller;

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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userAddressDtoValidator);
    }

    @RequestMapping(value = "/userSettings/createNewAddress", method = RequestMethod.GET)
    public String getCreateUserAddressPage(ModelMap model) {
        model.addAllAttributes(userAddressService.getUserAddressModel());
        return "userSettingsAddress";
    }

    @RequestMapping(value = "/userSettings/createNewAddress", method = RequestMethod.POST)
    public String createUserAddress(@Validated UserAddressDto userAddressDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(userAddressService.getUserAddressModel());
            return "userSettingsAddress";
        }

        userAddressService.saveUserAddress(userAddressDto);
        return "redirect:/userSettings/";
    }

    @RequestMapping(value = "/userSettings/editUserAddress-{id}", method = RequestMethod.GET)
    public String editUserAddress(@PathVariable Long id, ModelMap model) {
        if (userAddressService.currentUserHaveAccess(id)) {
            model.addAllAttributes(userAddressService.getUserAddressModelById(id));
            return "userSettingsAddress";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/userSettings/editUserAddress-{id}", method = RequestMethod.POST)
    public String updateUserAddress(@Validated UserAddressDto userAddressDto, BindingResult result, ModelMap model) {
        if (userAddressService.currentUserHaveAccess(userAddressDto.getId())) {
            if (result.hasErrors()) {
                model.mergeAttributes(userAddressService.getUserAddressModelById(userAddressDto.getId()));
                return "userSettingsAddress";
            }

            userAddressService.updateUserAddress(userAddressDto);
            return "redirect:/userSettings/";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = {"/userSettings/removeUserAddress-{id}"}, method = RequestMethod.GET)
    public String removeAddress(@PathVariable Long id) {
        if (userAddressService.currentUserHaveAccess(id)) {
            userAddressService.deleteUserAddress(id);
            return "redirect:/userSettings/";
        } else {
            return "page403AccessDenied";
        }
    }

}
