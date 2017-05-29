package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/userSettings/", method = RequestMethod.GET)
    public String getUserSettingsPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsWithAddressesModel());
        logger.info("Getting user settings page");
        return "userSettings";
    }

    @RequestMapping(value = "/userSettings/editGeneral", method = RequestMethod.GET)
    public String getUserSettingsEditPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
        logger.info("Getting user general settings editing page");
        return "userSettingsGeneral";
    }

    @RequestMapping(value = "/userSettings/editGeneral", method = RequestMethod.POST)
    public String updateUserSettings(UserDto userDto, BindingResult result, ModelMap model) {
        userDto.setUserDtoValidationType(UserDtoValidationType.UserGeneralInfo);
        userDtoValidator.validate(userDto, result);
        if (result.hasErrors()) {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
            logger.info("User general settings editing page - has errors");
            return "userSettingsGeneral";
        }

        if (userService.updateUser(userDto)) {
            logger.info("User general settings editing page - user general settings updated");
            return "redirect:/userSettings/";
        } else {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.UserGeneralInfo));
            logger.info("User general settings editing page - has errors");
            return "userSettingsGeneral";
        }
    }

    @RequestMapping(value = "/userSettings/changePassword", method = RequestMethod.GET)
    public String getUserChangePassPage(ModelMap model) {
        model.addAllAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
        logger.info("Getting password editing page");
        return "userSettingsPassword";
    }

    @RequestMapping(value = "/userSettings/changePassword", method = RequestMethod.POST)
    public String updateUserPass(UserDto userDto, BindingResult result, ModelMap model) {
        userDto.setUserDtoValidationType(UserDtoValidationType.Password);
        userDtoValidator.validate(userDto, result);
        if (result.hasErrors()) {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
            logger.info("Password editing page - has errors");
            return "userSettingsPassword";
        }

        if (userService.updatePassword(userDto)) {
            logger.info("Password editing page - password updated");
            return "redirect:/userSettings/";
        } else {
            model.mergeAttributes(userService.getUserSettingsModel(UserDtoValidationType.Password));
            logger.info("Password editing page - has errors");
            return "userSettingsPassword";
        }
    }
}
