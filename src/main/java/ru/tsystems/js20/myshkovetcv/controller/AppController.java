package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

    /**
     * This method will list all existing products.
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        model.addAttribute("title", "Home page");
        return "homepage";
    }

}
