package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import java.util.List;

public interface OrdersDao {

    Orders findById(Long id);

    void save(Orders orders);

    void updateOrders(Orders orders);

    List<Orders> findAllOrders();

    List<Orders> findAllOrdersByUser(User user);

    List<Orders> findAllOrdersByState(OrdersState ordersState);

    List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState);
}
