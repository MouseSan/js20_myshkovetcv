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

//        List<SoldProductInfo> soldProductInfos = new ArrayList<>();
        Map<ProductDto, Integer> productMap = shoppingCartService.getProductMap();
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            ProductDto productDto = entry.getKey();
            productDto.setStock(productDto.getStock() - entry.getValue());
            productService.updateProduct(productDto);

            SoldProductInfo soldProductInfo = new SoldProductInfo(productService.findById(productDto.getId()),
                    orders, productDto.getPrice(), entry.getValue());
            soldProductInfoService.saveSoldProductInfo(soldProductInfo);
//            soldProductInfos.add(soldProductInfo);
        }

//        orders.setSoldProductInfoList(soldProductInfos);
//        ordersDao.updateOrders(orders);

        shoppingCartService.removeAllProductFromCart();
    }

    @Override
    public void updateOrders(Orders orders) {
        Orders entity = ordersDao.findById(orders.getId());
        if (entity != null) {
            ordersDao.updateOrders(orders);
        }
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
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
    public ModelMap getOrdersModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("ordersDto", new OrdersDto());
        modelMap.addAttribute("totalPrice", shoppingCartService.getProductTotalPrice());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());
        return modelMap;
    }

    @Override
    public ModelMap getOrdersListModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDto(userService.getCurrentUserDto()));
        return modelMap;
    }

    @Override
    public ModelMap getOrdersListModel(OrdersState ordersState) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("ordersList", findAllOrdersDtoByUserDtoAndState(userService.getCurrentUserDto(), ordersState));
        return modelMap;
    }

    @Override
    public ModelMap getOrdersModelById(Long ordersId) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());

        Orders orders = findById(ordersId);
        List<SoldProductInfoDto> soldProductInfoDtos = new ArrayList<>();
        for (SoldProductInfo soldProductInfo : orders.getSoldProductInfoList()) {
            soldProductInfoDtos.add(new SoldProductInfoDto(soldProductInfo));
        }
        modelMap.addAttribute("productList", soldProductInfoDtos);
        modelMap.addAttribute("order", new OrdersDto(orders));
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
