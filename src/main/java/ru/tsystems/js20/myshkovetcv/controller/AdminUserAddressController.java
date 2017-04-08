package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;
import ru.tsystems.js20.myshkovetcv.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/useraddresses"}, method = RequestMethod.GET)
    public String listUserAddresses(ModelMap model) {
        List<UserAddress> userAddressList = userAddressService.findAllUserAddresses();
        model.addAttribute("userAddressList", userAddressList);
        model.addAttribute("title", "List of user address");
        return "AdminUserAddressList";
    }

    @RequestMapping(value = {"/useraddresses/createnew"}, method = RequestMethod.GET)
    public String newUserAddress(ModelMap model) {
        UserAddress userAddress = new UserAddress();
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userAddress", userAddress);
        model.addAttribute("title", "New user address");
        return "AdminUserAddressPage";
    }

    @RequestMapping(value = {"/useraddresses/createnew"}, method = RequestMethod.POST)
    public String saveUserAddress(UserAddress userAddress, BindingResult result, ModelMap model) {
        userAddressService.saveUserAddress(userAddress);
        return "redirect:/admin/useraddresses";
    }

    @RequestMapping(value = {"/useraddresses/edit-{id}"}, method = RequestMethod.GET)
    public String editUserAddress(@PathVariable Long id, ModelMap model) {
        UserAddress userAddress = userAddressService.findById(id);
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userAddress", userAddress);
        model.addAttribute("title", "Edit user address");
        return "AdminUserAddressPage";
    }

    @RequestMapping(value = {"/useraddresses/edit-{id}"}, method = RequestMethod.POST)
    public String updateUserAddress(UserAddress userAddress, BindingResult result, ModelMap model, @PathVariable Long id) {
        userAddressService.updateUserAddress(userAddress);
        return "redirect:/admin/useraddresses";
    }

}
