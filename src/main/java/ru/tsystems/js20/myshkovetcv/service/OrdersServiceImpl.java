package ru.tsystems.js20.myshkovetcv.service;

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

    @Override
    public Orders findById(Long id) {
        return ordersDao.findById(id);
    }

    @Override
    public void saveOrdersReduceStock(OrdersDto ordersDto) {
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

        Map<ProductDto, Integer> productMap = shoppingCartService.getProductMap();
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            ProductDto productDto = entry.getKey();
            productDto.setStock(productDto.getStock() - entry.getValue());
            productService.updateProduct(productDto);

            SoldProductInfo soldProductInfo = new SoldProductInfo(productService.findById(productDto.getId()),
                    orders, productDto.getPrice(), entry.getValue());
            soldProductInfoService.saveSoldProductInfo(soldProductInfo);
        }

        shoppingCartService.removeAllProductFromCart();
    }

    @Override
    public void updateOrders(OrdersDto ordersDto) {
        Orders entity = ordersDao.findById(ordersDto.getId());
        if (entity != null) {
            entity.setOrdersState(ordersDto.getOrdersState());
            entity.setPaymentState(ordersDto.getPaymentState());
            ordersDao.updateOrders(entity);
        }
    }

    @Override
    public List<OrdersDto> findAllOrdersDto() {
        List<Orders> ordersList = ordersDao.findAllOrders();
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByState(OrdersState ordersState) {
        List<Orders> ordersList = ordersDao.findAllOrdersByState(ordersState);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByUserDto(UserDto userDto) {
        List<Orders> ordersList = ordersDao.findAllOrdersByUser(userService.findById(userDto.getId()));
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> findAllOrdersDtoByUserDtoAndState(UserDto userDto, OrdersState ordersState) {
        List<Orders> ordersList = ordersDao.findAllOrdersByUserAndState(userService.findById(userDto.getId()), ordersState);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders));
        }
        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> getTopBuyers(Integer numberOfTops) {
        List<Orders> ordersList = ordersDao.getTopBuyers(numberOfTops);
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDtoList.add(new OrdersDto(orders.getUser(), orders.getTotalPrice()));
        }
        return ordersDtoList;
    }

    @Override
    public Double getEarningsForLastDays(Integer numberOfDays) {
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        Double totalEarnings = 0.0;
        for (Orders orders : ordersList) {
            totalEarnings += orders.getTotalPrice();
        }
        return totalEarnings;
    }

    @Override
    public Integer getTotalOrdersForLastDays(Integer numberOfDays) {
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        return ordersList.size();
    }

    @Override
    public Double getTotalQuantityOfProductsForLastDays(Integer numberOfDays) {
        List<Orders> ordersList = ordersDao.findAllOrdersForLastMonth();
        Double totalQuantity = 0.0;
        for (Orders orders : ordersList) {
            totalQuantity += orders.getTotalQuantity();
        }
        return totalQuantity;
    }

    @Override
    public ModelMap getOrdersModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersDto", new OrdersDto());
        modelMap.addAttribute("totalPrice", shoppingCartService.getProductTotalPrice());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());
        return modelMap;
    }

    @Override
    public ModelMap getCurrentUserOrdersListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDto(userService.getCurrentUserDto()));
        return modelMap;
    }

    @Override
    public ModelMap getCurrentUserOrdersListModel(OrdersState ordersState) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDtoAndState(userService.getCurrentUserDto(), ordersState));
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
        return modelMap;
    }

    @Override
    public ModelMap getAllOrdersListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDto());
        modelMap.addAttribute("adminPanel", true);
        return modelMap;
    }

    @Override
    public ModelMap getAllOrdersListModel(OrdersState ordersState) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByState(ordersState));
        modelMap.addAttribute("adminPanel", true);
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
                return currentUser.equals(ordersOwner);
            } else {
                return true;
            }
        }
    }
}
