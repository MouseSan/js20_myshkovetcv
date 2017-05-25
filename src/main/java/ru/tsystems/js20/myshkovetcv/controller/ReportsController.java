package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.service.SoldProductInfoService;

@Controller
@RequestMapping("/admin")
public class ReportsController {

    @Autowired
    private SoldProductInfoService soldProductInfoService;

    @RequestMapping(value = {"/reports/"}, method = RequestMethod.GET)
    public String getReports(ModelMap model) {
        model.addAllAttributes(soldProductInfoService.getReportsModel());
        return "reports";
    }
}
