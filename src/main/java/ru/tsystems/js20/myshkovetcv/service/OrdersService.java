package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Orders;

import java.util.List;

public interface OrdersService {

    Orders findById(Long id);

    void saveOrders(Orders orders);

    void updateOrders(Orders orders);

    List<Orders> findAllOrders();

}
