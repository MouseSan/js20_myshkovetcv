package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.service.UserService;
import ru.tsystems.js20.myshkovetcv.validators.UserDtoValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoValidator userDtoValidator;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        logger.info("Getting login page");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.info("Getting logout page");
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegistrationPage(ModelMap model) {
        model.addAttribute("userDto", new UserDto(UserDtoValidationType.Registration));
        logger.info("Getting new user page");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(UserDto userDto, BindingResult result, ModelMap model) {
        userDto.setUserDtoValidationType(UserDtoValidationType.Registration);
        userDtoValidator.validate(userDto, result);
        if (result.hasErrors()) {
            logger.info("New user page - has errors");
            return "register";
        }
        userService.saveUser(userDto);
        logger.info("New user page - user {} saved", userDto.getUserName());
        return "redirect:/login?registersuccess";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        logger.info("Getting access denied page");
        return "page403AccessDenied";
    }
}
