package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Order;

import java.util.List;

public interface OrderDao {

    Order findById(Long id);

    void save(Order order);

    void updateOrder(Order order);

    List<Order> findAllOrders();

}
