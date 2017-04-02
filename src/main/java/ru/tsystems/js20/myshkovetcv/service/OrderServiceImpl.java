package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.OrderDao;
import ru.tsystems.js20.myshkovetcv.dao.UserAddressDao;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.Order;

import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public Order findById(Long id) {
        return orderDao.findById(id);
    }

    @Override
    public void saveOrder(Order order) {
        order.setUser(userDao.findById(order.getUser().getId()));
        order.setUserAddress(userAddressDao.findById(order.getUserAddress().getId()));
        orderDao.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        Order entity = orderDao.findById(order.getId());
        if (entity != null) {
            orderDao.updateOrder(order);
        }
    }

    @Override
    public List<Order> findAllOrders() {
        return orderDao.findAllOrders();
    }
}
