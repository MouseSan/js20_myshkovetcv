package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import java.util.List;

@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao<Long, Orders> implements OrdersDao {

    @Override
    public Orders findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void save(Orders orders) {
        persist(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
        update(orders);
    }

    @Override
    public List<Orders> findAllOrders() {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o ORDER BY o.id ASC")
                .getResultList();
        return ordersList;
    }

    @Override
    public List<Orders> findAllOrdersByUser(User user) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.user = :user")
                .setParameter("user", user)
                .getResultList();
        return ordersList;
    }

    @Override
    public List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.user = :user AND o.ordersState = :ordersState")
                .setParameter("user", user)
                .setParameter("ordersState", ordersState)
                .getResultList();
        return ordersList;
    }
}
