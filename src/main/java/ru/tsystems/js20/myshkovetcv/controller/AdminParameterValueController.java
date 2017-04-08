package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Parameter;
import ru.tsystems.js20.myshkovetcv.model.ParameterValue;
import ru.tsystems.js20.myshkovetcv.service.ParameterService;
import ru.tsystems.js20.myshkovetcv.service.ParameterValueService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminParameterValueController {

    @Autowired
    private ParameterValueService parameterValueService;

    @Autowired
    private ParameterService parameterService;

    @RequestMapping(value = {"/parametervalues"}, method = RequestMethod.GET)
    public String listParameterValues(ModelMap model) {
        List<ParameterValue> parameterValueList = parameterValueService.findAllParameterValues();
        model.addAttribute("parameterValueList", parameterValueList);
        model.addAttribute("title", "List of parameter values");
        return "AdminParameterValueList";
    }

    @RequestMapping(value = {"/parametervalues/createnew"}, method = RequestMethod.GET)
    public String newParameterValue(ModelMap model) {
        ParameterValue parameterValue = new ParameterValue();
        List<Parameter> parameterList = parameterService.findAllParameters();

        model.addAttribute("parameterValue", parameterValue);
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("title", "New parameter value");
        return "AdminParameterValuePage";
    }

    @RequestMapping(value = {"/parametervalues/createnew"}, method = RequestMethod.POST)
    public String saveParameterValue(ParameterValue parameterValue, BindingResult result, ModelMap model) {
        parameterValueService.saveParameterValue(parameterValue);
        return "redirect:/admin/parametervalues";
    }

    @RequestMapping(value = {"/parametervalues/edit-{id}"}, method = RequestMethod.GET)
    public String editParameterValue(@PathVariable Long id, ModelMap model) {
        ParameterValue parameterValue = parameterValueService.findById(id);
        List<Parameter> parameterList = parameterService.findAllParameters();

        model.addAttribute("parameterValue", parameterValue);
        model.addAttribute("parameterList", parameterList);
        model.addAttribute("title", "Edit parameter value");
        return "AdminParameterValuePage";
    }

    @RequestMapping(value = {"/parametervalues/edit-{id}"}, method = RequestMethod.POST)
    public String updateParameterValue(ParameterValue parameterValue, BindingResult result, ModelMap model, @PathVariable Long id) {
        parameterValueService.updateParameterValue(parameterValue);
        return "redirect:/admin/parametervalues";
    }

}
