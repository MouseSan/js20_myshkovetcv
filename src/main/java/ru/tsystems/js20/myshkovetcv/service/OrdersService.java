package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.OrdersDto;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import java.util.List;

public interface OrdersService {

    Orders findById(Long id);

    void saveOrdersReduceStock(OrdersDto ordersDto);

    void updateOrders(Orders orders);

    List<Orders> findAllOrders();

    List<OrdersDto> findAllOrdersDtoByUserDto(UserDto userDto);

    List<OrdersDto> findAllOrdersDtoByUserDtoAndState(UserDto userDto, OrdersState ordersState);

    ModelMap getOrdersModel();

    ModelMap getOrdersListModel();

    ModelMap getOrdersListModel(OrdersState ordersState);

    ModelMap getOrdersModelById(Long ordersId);

    boolean currentUserHaveAccess(Long orderId);
}
