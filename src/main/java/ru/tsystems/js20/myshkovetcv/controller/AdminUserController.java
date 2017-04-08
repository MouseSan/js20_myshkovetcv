package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("title", "List of users");
        return "AdminUserList";
    }

    @RequestMapping(value = {"/users/createnew"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("title", "New user");
        return "AdminUserPage";
    }

    @RequestMapping(value = {"/users/createnew"}, method = RequestMethod.POST)
    public String saveUser(User user, BindingResult result, ModelMap model) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = {"/users/edit-{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable Long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "Edit user");
        return "AdminUserPage";
    }

    @RequestMapping(value = {"/users/edit-{id}"}, method = RequestMethod.POST)
    public String updateUser(User user, BindingResult result, ModelMap model, @PathVariable Long id) {
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

}
