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

    void updateOrders(OrdersDto ordersDto);

    List<OrdersDto> findAllOrdersDto();

    List<OrdersDto> findAllOrdersDtoByState(OrdersState ordersState);

    List<OrdersDto> findAllOrdersDtoByUserDto(UserDto userDto);

    List<OrdersDto> findAllOrdersDtoByUserDtoAndState(UserDto userDto, OrdersState ordersState);

    List<OrdersDto> getTopBuyers(Integer numberOfTops);

    ModelMap getOrdersModel();

    ModelMap getCurrentUserOrdersListModel();

    ModelMap getCurrentUserOrdersListModel(OrdersState ordersState);

    ModelMap getOrdersModelById(Long ordersId);

    ModelMap getAllOrdersListModel();

    ModelMap getAllOrdersListModel(OrdersState ordersState);

    boolean currentUserHaveAccess(Long orderId);
}
