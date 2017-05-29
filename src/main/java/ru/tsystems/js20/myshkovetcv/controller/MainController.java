package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.service.NavBarService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private NavBarService navBarService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        model.addAllAttributes(navBarService.getNavBarInfo());
        logger.info("Getting home page");
        return "indexPage";
    }
}
