package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;
import ru.tsystems.js20.myshkovetcv.service.UserService;
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

import static ru.tsystems.js20.myshkovetcv.util.SecurityUtil.getPrincipal;

@Controller
@RequestMapping("/userSettings")
public class MainUserSettingsController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserSettingsPage(ModelMap model) {
        model.addAttribute("user", userService.findByEmail(getPrincipal()));
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "User info");
        return "MainUserInfo";
    }

    @RequestMapping(value = "/editInfo", method = RequestMethod.GET)
    public String getUserSettingsEditPage(ModelMap model) {
        model.addAttribute("user", userService.findByEmail(getPrincipal()));
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "User settings");
        return "MainUserInfoEdit";
    }

    @RequestMapping(value = "/editInfo", method = RequestMethod.POST)
    public String updateUserSettings(User user, BindingResult result, ModelMap model) {
        userService.updateUser(user);
        return "redirect:/userSettings/";
    }

    @RequestMapping(value = {"/removeAddress"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String addToCart(@RequestParam Long addressId) {
        UserAddress userAddress = userAddressService.findById(addressId);
        userAddressService.deleteUserAddress(userAddress);
        return "";
    }

    @RequestMapping(value = "/editUserAddress-{id}", method = RequestMethod.GET)
    public String editUserAddress(@PathVariable Long id, ModelMap model) {
        UserAddress userAddress = userAddressService.findById(id);

        model.addAttribute("userAddress", userAddress);
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Edit address");
        return "MainUserEditAddress";
    }

    @RequestMapping(value = "/editUserAddress-{id}", method = RequestMethod.POST)
    public String updateUserAddress(UserAddress userAddress, BindingResult result, ModelMap model, @PathVariable Long id) {
        User user =  userService.findByEmail(getPrincipal());
        userAddress.setUser(user);
        userAddressService.updateUserAddress(userAddress);
        return "redirect:/userSettings/";
    }

    @RequestMapping(value = "/createNewAddress", method = RequestMethod.GET)
    public String getCreateUserAddressPage(ModelMap model) {
        UserAddress userAddress = new UserAddress();

        model.addAttribute("userAddress", userAddress);
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Edit address");
        return "MainUserEditAddress";
    }

    @RequestMapping(value = "/createNewAddress", method = RequestMethod.POST)
    public String createUserAddress(UserAddress userAddress, BindingResult result, ModelMap model) {
        User user =  userService.findByEmail(getPrincipal());
        userAddress.setUser(user);
        userAddressService.saveUserAddress(userAddress);
        return "redirect:/userSettings/";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String getUserChangePassPage(ModelMap model) {
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Change user password");
        return "MainUserPasswordEdit";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String updateUserPass(@RequestParam String password) {
        User user = userService.findByEmail(getPrincipal());
        userService.updatePassword(user, password);
        return "redirect:/userSettings/";
    }

}
