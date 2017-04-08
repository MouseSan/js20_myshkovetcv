package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Parameter;
import ru.tsystems.js20.myshkovetcv.model.enums.ParameterType;
import ru.tsystems.js20.myshkovetcv.service.ParameterService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminParameterController {

    @Autowired
    private ParameterService parameterService;

    @RequestMapping(value = {"/parameters"}, method = RequestMethod.GET)
    public String listParameters(ModelMap model) {
        List<Parameter> parameterList = parameterService.findAllParameters();
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("title", "List of parameters");
        return "AdminParameterList";
    }

    @RequestMapping(value = {"/parameters/createnew"}, method = RequestMethod.GET)
    public String newParameter(ModelMap model) {
        Parameter parameter = new Parameter();
        model.addAttribute("parameter", parameter);
        model.addAttribute("parameterType", ParameterType.values());
        model.addAttribute("title", "New parameter");
        return "AdminParameterPage";
    }

    @RequestMapping(value = {"/parameters/createnew"}, method = RequestMethod.POST)
    public String saveParameter(Parameter parameter, BindingResult result, ModelMap model) {
        parameterService.saveParameter(parameter);
        return "redirect:/admin/parameters";
    }

    @RequestMapping(value = {"/parameters/edit-{id}"}, method = RequestMethod.GET)
    public String editParameter(@PathVariable Long id, ModelMap model) {
        Parameter parameter = parameterService.findById(id);
        model.addAttribute("parameter", parameter);
        model.addAttribute("parameterType", ParameterType.values());
        model.addAttribute("title", "Edit parameter");
        return "AdminParameterPage";
    }

    @RequestMapping(value = {"/parameters/edit-{id}"}, method = RequestMethod.POST)
    public String updateParameter(Parameter parameter, BindingResult result, ModelMap model, @PathVariable Long id) {
        parameterService.updateParameter(parameter);
        return "redirect:/admin/parameters";
    }

}
