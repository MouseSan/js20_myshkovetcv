package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.OrdersDao;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;
import ru.tsystems.js20.myshkovetcv.sessionScope.ShoppingCart;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static ru.tsystems.js20.myshkovetcv.util.SecurityUtil.getPrincipal;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShoppingCart shoppingCart;

    @Override
    public Orders findById(Long id) {
        return ordersDao.findById(id);
    }

    @Override
    public void saveOrders(Orders orders) {
        if (orders.getPaymentMethod().equals(PaymentMethod.Card)) {
            orders.setPaymentState(PaymentState.Paid);
        } else {
            orders.setPaymentState(PaymentState.Pending);
        }
        if (orders.getDeliveryMethod().equals(DeliveryMethod.Pickup)) {
            orders.setDeliveryAddress("Self pickup");
        }

        Map<Product, Integer> productMap = shoppingCart.getProductMap();
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                orders.addProductToList(entry.getKey());
            }
        }

        User user = userDao.findByEmail(getPrincipal());
        orders.setUser(user);
        orders.setOrdersState(OrdersState.WaitingForShipment);
        orders.setTotalPrice(shoppingCart.getProductTotalPrice());
        orders.setTotalQuantity(shoppingCart.getProductQuantityInCart());
        orders.setUser(userDao.findById(orders.getUser().getId()));
        orders.setDateOfOrder(new Date());

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

    @Override
    public List<Orders> findAllOrdersByUser(User user) {
        return ordersDao.findAllOrdersByUser(user);
    }

    @Override
    public List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState) {
        return ordersDao.findAllOrdersByUserAndState(user, ordersState);
    }
}
