package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.OrdersDao;
import ru.tsystems.js20.myshkovetcv.dao.UserAddressDao;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.Orders;

import java.util.List;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public Orders findById(Long id) {
        return ordersDao.findById(id);
    }

    @Override
    public void saveOrders(Orders orders) {
        orders.setUser(userDao.findById(orders.getUser().getId()));
        orders.setUserAddress(userAddressDao.findById(orders.getUserAddress().getId()));
        ordersDao.save(orders);
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
}
