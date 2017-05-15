package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import java.util.List;
import java.util.Map;

public interface OrdersService {

    Orders findById(Long id);

    void saveOrdersReduceStock(Orders orders);

    void updateOrders(Orders orders);

    List<Orders> findAllOrders();

    List<Orders> findAllOrdersByUser(User user);

    List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState);

    Map<Product, Integer> getProductMap(Orders orders);

    Orders copyOrder(Long id);

    boolean checkAvailableToRepeat(Orders orders);

    void saveCopiedOrdersReduceStock(Orders orders);

    ModelMap getOrdersModel();
}
