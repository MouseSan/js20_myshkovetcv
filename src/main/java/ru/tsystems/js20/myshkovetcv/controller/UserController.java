package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.service.UserService;
import ru.tsystems.js20.myshkovetcv.validators.UserDtoValidator;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoValidator userDtoValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userDtoValidator);
    }

    @RequestMapping(value = "/userSettings/", method = RequestMethod.GET)
    public String getUserSettingsPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsWithAddressesModel());
        return "userSettings";
    }

    @RequestMapping(value = "/userSettings/editGeneral", method = RequestMethod.GET)
    public String getUserSettingsEditPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
        return "userSettingsGeneral";
    }

    @RequestMapping(value = "/userSettings/editGeneral", method = RequestMethod.POST)
    public String updateUserSettings(@Validated UserDto userDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
            return "userSettingsGeneral";
        }

        if (userService.updateUser(userDto)) {
            return "redirect:/userSettings/";
        } else {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
            return "userSettingsGeneral";
        }
    }

    @RequestMapping(value = "/userSettings/changePassword", method = RequestMethod.GET)
    public String getUserChangePassPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
        return "userSettingsPassword";
    }

    @RequestMapping(value = "/userSettings/changePassword", method = RequestMethod.POST)
    public String updateUserPass(@Validated UserDto userDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
            return "userSettingsPassword";
        }

        if (userService.updatePassword(userDto)) {
            return "redirect:/userSettings/";
        } else {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
            return "userSettingsPassword";
        }
    }
}
