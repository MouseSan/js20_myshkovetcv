package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;
import ru.tsystems.js20.myshkovetcv.service.OrdersService;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;
import ru.tsystems.js20.myshkovetcv.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = {"/orders"}, method = RequestMethod.GET)
    public String listOrders(ModelMap model) {
        List<Orders> ordersList = ordersService.findAllOrders();
        model.addAttribute("ordersList", ordersList);
        model.addAttribute("title", "List of orders");
        return "AdminOrdersList";
    }

    @RequestMapping(value = {"/orders/createnew"}, method = RequestMethod.GET)
    public String newOrder(ModelMap model) {
        Orders orders = new Orders();
        List<User> userList = userService.findAllUsers();
        List<UserAddress> userAddressList = userAddressService.findAllUserAddresses();

        model.addAttribute("orders", orders);
        model.addAttribute("userList", userList);
        model.addAttribute("userAddressList", userAddressList);
        model.addAttribute("paymentMethodList", PaymentMethod.values());
        model.addAttribute("deliveryMethodList", DeliveryMethod.values());
        model.addAttribute("paymentStateList", PaymentState.values());
        model.addAttribute("ordersStateList", OrdersState.values());
        model.addAttribute("title", "New order");
        return "AdminOrdersPage";
    }

    @RequestMapping(value = {"/orders/createnew"}, method = RequestMethod.POST)
    public String saveOrder(Orders orders, BindingResult result, ModelMap model) {
        ordersService.saveOrdersReduceStock(orders);
        return "redirect:/admin/orders";
    }

    @RequestMapping(value = {"/orders/edit-{id}"}, method = RequestMethod.GET)
    public String editOrder(@PathVariable Long id, ModelMap model) {
        Orders orders = ordersService.findById(id);
        List<User> userList = userService.findAllUsers();
        List<UserAddress> userAddressList = userAddressService.findAllUserAddresses();

        model.addAttribute("orders", orders);
        model.addAttribute("userList", userList);
        model.addAttribute("userAddressList", userAddressList);
        model.addAttribute("paymentMethodList", PaymentMethod.values());
        model.addAttribute("deliveryMethodList", DeliveryMethod.values());
        model.addAttribute("paymentStateList", PaymentState.values());
        model.addAttribute("ordersStateList", OrdersState.values());
        model.addAttribute("title", "Edit order");
        return "AdminOrdersPage";
    }

    @RequestMapping(value = {"/orders/edit-{id}"}, method = RequestMethod.POST)
    public String updateOrder(Orders orders, BindingResult result, ModelMap model, @PathVariable Long id) {
        ordersService.updateOrders(orders);
        return "redirect:/admin/orders";
    }

}
