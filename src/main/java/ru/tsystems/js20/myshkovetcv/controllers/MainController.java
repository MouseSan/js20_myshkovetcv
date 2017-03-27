package ru.tsystems.js20.myshkovetcv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.services.GoodsService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {
        model.addAttribute("goods", goodsService.getAllGoods());
        return "main";
    }
}
