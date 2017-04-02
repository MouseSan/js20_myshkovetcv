package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Order;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Long, Order> implements OrderDao {

    @Override
    public Order findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void save(Order order) {
        persist(order);
    }

    @Override
    public void updateOrder(Order order) {
        update(order);
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orderList = getEntityManager()
                .createQuery("SELECT o FROM ru.tsystems.js20.myshkovetcv.model.Order o ORDER BY o.id ASC")
                .getResultList();
        return orderList;
    }
}
