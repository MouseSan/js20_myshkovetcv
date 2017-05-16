package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.js20.myshkovetcv.dto.OrdersDto;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.service.OrdersService;
import ru.tsystems.js20.myshkovetcv.service.ShoppingCartService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreateOrderPage(ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            return "redirect:/cart?notEnoughQuantity=true";
        }
        model.addAllAttributes(ordersService.getOrdersModel());
        return "ordersCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            return "redirect:/cart?notEnoughQuantity=true";
        }
        ordersService.saveOrdersReduceStock(ordersDto);
        return "redirect:/orders/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getOrdersListModel());
        return "ordersList";
    }

    @RequestMapping(value = "/pending", method = RequestMethod.GET)
    public String getPendingOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getOrdersListModel(OrdersState.Pending));
        return "ordersList";
    }

    @RequestMapping(value = "/waitingforshipment", method = RequestMethod.GET)
    public String getWaitingForShipmentOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getOrdersListModel(OrdersState.WaitingForShipment));
        return "ordersList";
    }

    @RequestMapping(value = "/shipped", method = RequestMethod.GET)
    public String getShippedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getOrdersListModel(OrdersState.Shipped));
        return "ordersList";
    }

    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String getCompletedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getOrdersListModel(OrdersState.Completed));
        return "ordersList";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrderPageById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            model.addAllAttributes(ordersService.getOrdersModelById(id));
            return "ordersPage";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/repeat-{id}", method = RequestMethod.GET)
    public String copyOrderById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            shoppingCartService.copyProductsFromOrder(id);
            return "redirect:/orders/create";
        } else {
            return "page403AccessDenied";
        }
    }
}
