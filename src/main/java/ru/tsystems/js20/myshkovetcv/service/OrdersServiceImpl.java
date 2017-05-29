package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.OrdersDao;
import ru.tsystems.js20.myshkovetcv.dto.*;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private SoldProductInfoService soldProductInfoService;
    @Autowired
    private NavBarService navBarService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Orders findById(Long id) {
        logger.debug("Trying to find order: {}", id);
        return ordersDao.findById(id);
    }

    @Override
    public void saveOrdersReduceStock(OrdersDto ordersDto) {
        logger.debug("Start saving order");
        Orders orders = new Orders();

        orders.setPaymentMethod(ordersDto.getPaymentMethod());
        orders.setPaymentState(PaymentState.NotPaid);
        orders.setOrdersState(OrdersState.WaitingForShipment);
        orders.setUser(userService.getCurrentUser());
        orders.setTotalPrice(shoppingCartService.getProductTotalPrice());
        orders.setTotalQuantity(shoppingCartService.getProductQuantityInCart());
        orders.setDateOfOrder(new Date());

        if (ordersDto.getDeliveryMethod().equals(DeliveryMethod.Pickup)) {
            orders.setDeliveryMethod(DeliveryMethod.Pickup);
            orders.setDeliveryAddress("Self pickup");
        } else if (ordersDto.getDeliveryMethod().equals(DeliveryMethod.ExpressDelivery)){
            orders.setDeliveryMethod(DeliveryMethod.ExpressDelivery);
            if (ordersDto.getDeliveryAddress().equals("New Address")) {
                orders.setDeliveryAddress(ordersDto.getNewDeliveryAddress());
                userAddressService.saveUserAddress(new UserAddressDto(ordersDto));
            } else {
                orders.setDeliveryAddress(ordersDto.getDeliveryAddress());
            }
        }

        ordersDao.save(orders);
        logger.debug("Order saved");

        Map<ProductDto, Integer> productMap = shoppingCartService.getProductMap();
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            ProductDto productDto = entry.getKey();
            productDto.setStock(productDto.getStock() - entry.getValue());
            productService.updateProduct(productDto);

            SoldProductInfo soldProductInfo = new SoldProductInfo(productService.findById(productDto.getId()),
                    orders, productDto.getPrice(), entry.getValue());
            soldProductInfoService.saveSoldProductInfo(soldProductInfo);
        }
        logger.debug("Info about sold products saved");

        shoppingCartService.removeAllProductFromCart();
    }

    @Override
    public void updateOrders(OrdersDto ordersDto) {
        logger.debug("Start updating states in order");
        Orders entity = ordersDao.findById(ordersDto.getId());
        if (entity != null) {
            entity.setOrdersState(ordersDto.getOrdersState());
            entity.setPaymentState(ordersDto.getPaymentState());
            ordersDao.updateOrders(entity);
            logger.debug("States updated in order");
        } else {
            logger.warn("States not updated in order");
        }
    }

    @Override
    public List<OrdersDto> findAllOrdersDto() {
        logger.debug("Start selecting list of all OrdersDtos");
        List<Orders> ordersList = ordersDao.findAllOrders();
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        logger.debug("List of all OrdersDtos selected");
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByState(OrdersState ordersState) {
        logger.debug("Start selecting list of all OrdersDtos by state: {}", ordersState);
        List<Orders> ordersList = ordersDao.findAllOrdersByState(ordersState);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        logger.debug("List of all OrdersDtos by state: {}, selected", ordersState);
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByUserDto(UserDto userDto) {
        logger.debug("Start selecting list of all OrdersDtos for user: {}@{}", userDto.getUserName(), userDto.getEmailAddress());
        List<Orders> ordersList = ordersDao.findAllOrdersByUser(userService.findById(userDto.getId()));
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        logger.debug("List of all OrdersDtos for user: {}@{}, selected", userDto.getUserName(), userDto.getEmailAddress());
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByUserDtoAndState(UserDto userDto, OrdersState ordersState) {
        logger.debug("Start selecting list of all OrdersDtos for user: {}@{}, by state: {}", userDto.getUserName(), userDto.getEmailAddress(), ordersState);
        List<Orders> ordersList = ordersDao.findAllOrdersByUserAndState(userService.findById(userDto.getId()), ordersState);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        logger.debug("List of all OrdersDtos for user: {}@{}, by state: {}, selected",
                userDto.getUserName(), userDto.getEmailAddress(), ordersState);
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> getTopBuyers(Integer numberOfTops) {
        logger.debug("Start selecting list of top {} buyers", numberOfTops);
        List<Orders> ordersList = ordersDao.getTopBuyers(numberOfTops);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders.getUser(), orders.getTotalPrice()));
        }
        logger.debug("List of top {} buyers selected", numberOfTops);
        return ordersDtoList;
    }

    @Override
    public Double getEarningsForLastMonth() {
        logger.debug("Start selecting earnings for last month");
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        Double totalEarnings = 0.0;
        for (Orders orders : ordersList) {
            totalEarnings += orders.getTotalPrice();
        }
        logger.debug("Earnings for last month: {}, selected", totalEarnings);
        return totalEarnings;
    }

    @Override
    public Integer getTotalOrdersForLastMonth() {
        logger.debug("Start selecting total orders for lastMonth");
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        logger.debug("Total orders for lastMonth: {}, selected", ordersList.size());
        return ordersList.size();
    }

    @Override
    public Double getTotalQuantityOfProductsForLastMonth() {
        logger.debug("Start selecting total quantity of products for last month");
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        Double totalQuantity = 0.0;
        for (Orders orders : ordersList) {
            totalQuantity += orders.getTotalQuantity();
        }
        logger.debug("Total quantity of products for last month {}, selected", totalQuantity);
        return totalQuantity;
    }

    @Override
    public ModelMap getOrdersModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersDto", new OrdersDto());
        modelMap.addAttribute("totalPrice", shoppingCartService.getProductTotalPrice());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());
        logger.debug("New order model formed");
        return modelMap;
    }

    @Override
    public ModelMap getCurrentUserOrdersListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        UserDto userDto = userService.getCurrentUserDto();
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDto(userDto));
        logger.debug("Current user {}@{} orders list model formed", userDto.getUserName(), userDto.getEmailAddress());
        return modelMap;
    }

    @Override
    public ModelMap getCurrentUserOrdersListModel(OrdersState ordersState) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        UserDto userDto = userService.getCurrentUserDto();
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDtoAndState(userDto, ordersState));
        logger.debug("Current user {}@{} orders list by order state {} model formed",
                userDto.getUserName(), userDto.getEmailAddress(), ordersState);
        return modelMap;
    }

    @Override
    public ModelMap getOrdersModelById(Long ordersId) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());

        Orders orders = findById(ordersId);
        List<SoldProductInfoDto> soldProductInfoDtos = new ArrayList<>();
        for (SoldProductInfo soldProductInfo : orders.getSoldProductInfoList()) {
            soldProductInfoDtos.add(new SoldProductInfoDto(soldProductInfo));
        }
        modelMap.addAttribute("productList", soldProductInfoDtos);
        modelMap.addAttribute("ordersStateList", OrdersState.values());
        modelMap.addAttribute("paymentStateList", PaymentState.values());
        modelMap.addAttribute("deliveryMethodList", DeliveryMethod.values());
        modelMap.addAttribute("paymentMethodList", PaymentMethod.values());
        modelMap.addAttribute("order", new OrdersDto(orders));
        logger.debug("Order model formed {}", ordersId);
        return modelMap;
    }

    @Override
    public ModelMap getAllOrdersListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDto());
        modelMap.addAttribute("adminPanel", true);
        logger.debug("All orders list model formed");
        return modelMap;
    }

    @Override
    public ModelMap getAllOrdersListModel(OrdersState ordersState) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByState(ordersState));
        modelMap.addAttribute("adminPanel", true);
        logger.debug("All orders list by state {} model formed", ordersState);
        return modelMap;
    }

    @Override
    public boolean currentUserHaveAccess(Long orderId) {
        User currentUser = userService.getCurrentUser();
        if (userService.hasRole("ROLE_ADMIN")) {
            return true;
        } else {
            Orders orders = ordersDao.findById(orderId);
            if (orders != null) {
                User ordersOwner = orders.getUser();
                logger.debug("User {} try to access order {}", currentUser.getUserName(), orderId);
                return currentUser.equals(ordersOwner);
            } else {
                logger.warn("Order #{} not found ", orderId);
                return true;
            }
        }
    }
}
