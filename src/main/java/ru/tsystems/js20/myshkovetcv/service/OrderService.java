package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Order;

import java.util.List;

public interface OrderService {

    Order findById(Long id);

    void saveOrder(Order order);

    void updateOrder(Order order);

    List<Order> findAllOrders();

}
