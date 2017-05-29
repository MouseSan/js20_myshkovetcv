package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/orders/create", method = RequestMethod.GET)
    public String getCreateOrderPage(ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            if (shoppingCartService.getProductQuantityInCart() < 1) {
                logger.info("Order creation page - no products in shopping cart");
                return "redirect:/cart?noProductsInCart=true";
            }
            logger.info("Order creation page - not enough products in stock");
            return "redirect:/cart?notEnoughQuantity=true";
        }
        model.addAllAttributes(ordersService.getOrdersModel());
        logger.info("Getting orders creating page");
        return "ordersCreate";
    }

    @RequestMapping(value = "/orders/create", method = RequestMethod.POST)
    public String createOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if(!shoppingCartService.allProductsAvailable()) {
            if (shoppingCartService.getProductQuantityInCart() < 1) {
                logger.info("Order creation page - no products in shopping cart");
                return "redirect:/cart?noProductsInCart=true";
            }
            logger.info("Order creation page - not enough products in stock");
            return "redirect:/cart?notEnoughQuantity=true";
        }
        ordersService.saveOrdersReduceStock(ordersDto);
        logger.info("Orders creating page - order created");
        return "redirect:/orders/all";
    }

    @RequestMapping(value = "/orders/all", method = RequestMethod.GET)
    public String getAllUserOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel());
        logger.info("Getting list of all orders page for current user");
        return "ordersList";
    }

    @RequestMapping(value = "/orders/pending", method = RequestMethod.GET)
    public String getPendingOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Pending));
        logger.info("Getting list of pending orders page for current user");
        return "ordersList";
    }

    @RequestMapping(value = "/orders/waitingforshipment", method = RequestMethod.GET)
    public String getWaitingForShipmentOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.WaitingForShipment));
        logger.info("Getting list of waiting for shipment orders page for current user");
        return "ordersList";
    }

    @RequestMapping(value = "/orders/shipped", method = RequestMethod.GET)
    public String getShippedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Shipped));
        logger.info("Getting list of shipped orders page for current user");
        return "ordersList";
    }

    @RequestMapping(value = "/orders/completed", method = RequestMethod.GET)
    public String getCompletedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getCurrentUserOrdersListModel(OrdersState.Completed));
        logger.info("Getting list of completed orders page for current user");
        return "ordersList";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrderPageById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            model.addAllAttributes(ordersService.getOrdersModelById(id));
            logger.info("Getting orders ID:{} editing page", id);
            return "ordersPage";
        } else {
            logger.warn("Access denied for order ID:{}", id);
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String updateOrder(OrdersDto ordersDto, BindingResult result, ModelMap model) {
        if (ordersService.currentUserHaveAccess(ordersDto.getId())) {
            if (result.hasErrors()) {
                model.mergeAttributes(ordersService.getOrdersModelById(ordersDto.getId()));
                logger.info("Orders editing page - has errors");
                return "ordersPage";
            }

            ordersService.updateOrders(ordersDto);
            logger.info("Orders editing page - order {} updated", ordersDto.getId());
            return "redirect:/admin/orders/";
        } else {
            logger.warn("Access denied for order ID:{}", ordersDto.getId());
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/orders/repeat-{id}", method = RequestMethod.GET)
    public String copyOrderById(@PathVariable Long id, ModelMap model) {
        if (ordersService.currentUserHaveAccess(id)) {
            shoppingCartService.copyProductsFromOrder(id);
            logger.info("Orders creating page - order {} copied", id);
            return "redirect:/orders/create";
        } else {
            logger.warn("Access denied for order ID:{}", id);
            return "page403AccessDenied";
        }
    }

    @RequestMapping(value = "/admin/orders/", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel());
        logger.info("Getting list of all orders page");
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/pending/", method = RequestMethod.GET)
    public String getAllPendingOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Pending));
        logger.info("Getting list of pending orders page");
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/waitingforshipment/", method = RequestMethod.GET)
    public String getAllWaitingForShipmentOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.WaitingForShipment));
        logger.info("Getting list of waiting for shipment orders page");
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/shipped/", method = RequestMethod.GET)
    public String getAllShippedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Shipped));
        logger.info("Getting list of shipped orders page");
        return "ordersList";
    }

    @RequestMapping(value = "/admin/orders/completed/", method = RequestMethod.GET)
    public String getAllCompletedOrders(ModelMap model) {
        model.addAllAttributes(ordersService.getAllOrdersListModel(OrdersState.Completed));
        logger.info("Getting list of completed orders page");
        return "ordersList";
    }
}
