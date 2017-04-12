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
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.service.CategoryService;
import ru.tsystems.js20.myshkovetcv.service.OrdersService;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;
import ru.tsystems.js20.myshkovetcv.service.UserService;
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

import static ru.tsystems.js20.myshkovetcv.util.SecurityUtil.getPrincipal;

@Controller
@RequestMapping("/orders")
public class MainOrdersController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreateOrderPage(ModelMap model) {
        User currentUser = userService.findByEmail(getPrincipal());
        Orders order = new Orders();
        order.setPaymentMethod(PaymentMethod.Cash);
        order.setDeliveryMethod(DeliveryMethod.Pickup);

        model.addAttribute("order", order);
        model.addAttribute("user", currentUser);
        model.addAttribute("productMap", shoppingCart.getProductMap());
        model.addAttribute("userAddressList", userAddressService.findUserAddresses(currentUser));
        model.addAttribute("paymentMethodList", PaymentMethod.values());
        model.addAttribute("deliveryMethodList", DeliveryMethod.values());

        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("totalPrice", shoppingCart.getProductTotalPrice());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Checkout");
        return "MainOrdersCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(Orders orders, BindingResult result, ModelMap model) {
        ordersService.saveOrders(orders);
        return "redirect:/orders/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllOrders(ModelMap model) {
        User user = userService.findByEmail(getPrincipal());
        model.addAttribute("ordersList", ordersService.findAllOrdersByUser(user));
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
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
        User user = userService.findByEmail(getPrincipal());
        model.addAttribute("ordersList", ordersService.findAllOrdersByUserAndState(user, state));
        model.addAttribute("ordersState", state);
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Orders list");
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrderPageById(@PathVariable Long id, ModelMap model) {
        Orders orders = ordersService.findById(id);
        User ordersUser = orders.getUser();
        User loggedInUser = userService.findByEmail(getPrincipal());

        if (!loggedInUser.equals(ordersUser)) {
            return "Page403AccessDenied";
        }

        model.addAttribute("order", orders);
        model.addAttribute("ordersProductList", orders.getProductMap());
        model.addAttribute("quantityInCart", shoppingCart.getProductQuantityInCart());
        model.addAttribute("categoryList", categoryService.findAllCategories());
        model.addAttribute("title", "Order #" + id);
        return "MainOrdersPage";
    }

}
