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
@RequestMapping("/")
public class OrdersController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/orders/create", method = RequestMethod.GET)
    public String getCreateOrderPage(ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            if (shoppingCartService.getProductQuantityInCart() < 1) {
                return "redirect:/cart?noProductsInCart=true";
            }
            return "redirect:/cart?notEnoughQuantity=true";
        }
        model.addAllAttributes(ordersService.getOrdersModel());
        return "ordersCreate";
    }

    @RequestMapping(value = "/orders/create", method = RequestMethod.POST)
    public String createOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            if (shoppingCartService.getProductQuantityInCart() < 1) {
                return "redirect:/cart?noProductsInCart=true";
            }
            return "redirect:/cart?notEnoughQuantity=true";
        }
        ordersService.saveOrdersReduceStock(ordersDto);
        return "redirect:/orders/all";
    }

    @RequestMapping(value = "/orders/all", method = RequestMethod.GET)
    public String getAllUserOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel());
        return "ordersList";
    }

    @RequestMapping(value = "/orders/pending", method = RequestMethod.GET)
    public String getPendingOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Pending));
        return "ordersList";
    }

    @RequestMapping(value = "/orders/waitingforshipment", method = RequestMethod.GET)
    public String getWaitingForShipmentOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.WaitingForShipment));
        return "ordersList";
    }

    @RequestMapping(value = "/orders/shipped", method = RequestMethod.GET)
    public String getShippedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Shipped));
        return "ordersList";
    }

    @RequestMapping(value = "/orders/completed", method = RequestMethod.GET)
    public String getCompletedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Completed));
        return "ordersList";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrderPageById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            model.addAllAttributes(ordersService.getOrdersModelById(id));
            return "ordersPage";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String updateOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if (ordersService.currentUserHaveAccess(ordersDto.getId())) {
            if (result.hasErrors()) {
                model.mergeAttributes(ordersService.getOrdersModelById(ordersDto.getId()));
                return "ordersPage";
            }

            ordersService.updateOrders(ordersDto);
            return "redirect:/admin/orders/";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/orders/repeat-{id}", method = RequestMethod.GET)
    public String copyOrderById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            shoppingCartService.copyProductsFromOrder(id);
            return "redirect:/orders/create";
        } else {
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/admin/orders/", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel());
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/pending/", method = RequestMethod.GET)
    public String getAllPendingOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Pending));
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/waitingforshipment/", method = RequestMethod.GET)
    public String getAllWaitingForShipmentOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.WaitingForShipment));
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/shipped/", method = RequestMethod.GET)
    public String getAllShippedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Shipped));
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/completed/", method = RequestMethod.GET)
    public String getAllCompletedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Completed));
        return "ordersList";
    }
}
