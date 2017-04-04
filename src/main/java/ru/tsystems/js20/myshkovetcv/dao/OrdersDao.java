package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Orders;

import java.util.List;

public interface OrdersDao {

    Orders findById(Long id);

    void save(Orders orders);

    void updateOrders(Orders orders);

    List<Orders> findAllOrders();

}
