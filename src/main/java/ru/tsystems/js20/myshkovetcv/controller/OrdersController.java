package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.OrdersDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.service.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreateOrderPage(ModelMap model) {

        model.addAllAttributes(ordersService.getOrdersModel());
//        if(!shoppingCartService.checkAvailability()) {
//            return "redirect:/cart?enoughquantity";
//        }

//        model.addAttribute("user", currentUser);
//        model.addAttribute("productMap", shoppingCartService.getProductMap());
//        model.addAttribute("userAddressList", userAddressService.findUserAddressDto(currentUser));
//        model.addAttribute("paymentMethodList", PaymentMethod.values());
//        model.addAttribute("deliveryMethodList", DeliveryMethod.values());
//        model.addAttribute("totalPrice", shoppingCartService.getProductTotalPrice());
        return "ordersCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if(!shoppingCartService.checkAvailability()) {
            return "redirect:/cart?enoughquantity";
        }

//        ordersService.saveOrdersReduceStock(orders);
        return "redirect:/orders/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        User user = userService.getCurrentUser();
        model.addAttribute("ordersList", ordersService.findAllOrdersByUser(user));
        model.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        model.addAttribute("title", "All orders");
        return "MainOrdersList";
    }

    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public String getPendingOrders(ModelMap model) {
        model = fillModelWithListOfOrdersByState(model, OrdersState.Pending);
        return "MainOrdersList";
    }

    @RequestMapping(value = "/waitingforshipment", method = RequestMethod.GET)
    public String getWaitingForShipmentOrders(ModelMap model) {
        model = fillModelWithListOfOrdersByState(model, OrdersState.WaitingForShipment);
        return "MainOrdersList";
    }

    @RequestMapping(value = "/shipped", method = RequestMethod.GET)
    public String getShippedOrders(ModelMap model) {
        model = fillModelWithListOfOrdersByState(model, OrdersState.Shipped);
        return "MainOrdersList";
    }

    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String getCompletedOrders(ModelMap model) {
        model = fillModelWithListOfOrdersByState(model, OrdersState.Completed);
        return "MainOrdersList";
    }

    private ModelMap fillModelWithListOfOrdersByState(ModelMap model, OrdersState state) {
        User user = userService.getCurrentUser();
        model.addAttribute("ordersList", ordersService.findAllOrdersByUserAndState(user, state));
        model.addAttribute("ordersState", state);
        model.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        model.addAttribute("title", "Orders list");
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrderPageById(@PathVariable Long id, ModelMap model) {
        Orders orders = ordersService.findById(id);
        User ordersUser = orders.getUser();
        User loggedInUser = userService.getCurrentUser();

        if (!loggedInUser.equals(ordersUser)) {
            return "Page403AccessDenied";
        }

        model.addAttribute("order", orders);
        model.addAttribute("ordersProductList", ordersService.getProductMap(orders));
        model.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        model.addAttribute("title", "Order #" + id);
        return "MainOrdersPage";
    }

    @RequestMapping(value = "/repeat-{id}", method = RequestMethod.GET)
    public String copyOrderById(@PathVariable Long id, ModelMap model) {
        Orders orders = ordersService.findById(id);
        User ordersUser = orders.getUser();
        User loggedInUser = userService.getCurrentUser();
        if (!loggedInUser.equals(ordersUser)) {
            return "Page403AccessDenied";
        }

        if(!ordersService.checkAvailableToRepeat(orders)) {
            return "redirect:/orders/{id}?enoughquantity";
        }

        Orders copiedOrder = ordersService.copyOrder(id);

        model.addAttribute("order", copiedOrder);
        model.addAttribute("user", loggedInUser);
        model.addAttribute("productMap", ordersService.getProductMap(copiedOrder));
        model.addAttribute("userAddressList", userAddressService.findUserAddressDto(loggedInUser));
        model.addAttribute("paymentMethodList", PaymentMethod.values());
        model.addAttribute("deliveryMethodList", DeliveryMethod.values());
        model.addAttribute("quantityInCart", copiedOrder.getTotalQuantity());
        model.addAttribute("totalPrice", copiedOrder.getTotalPrice());
        model.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        model.addAttribute("title", "Checkout");
        return "MainOrdersCreate";
    }

    @RequestMapping(value = "/repeat-{id}", method = RequestMethod.POST)
    public String createCopiedOrder(@PathVariable Long id, Orders orders, BindingResult result, ModelMap model) {

        if(!ordersService.checkAvailableToRepeat(orders)) {
            return "redirect:/orders/{" + id + "}?enoughquantity";
        }

        ordersService.saveCopiedOrdersReduceStock(orders);
        return "redirect:/orders/all";
    }

}
