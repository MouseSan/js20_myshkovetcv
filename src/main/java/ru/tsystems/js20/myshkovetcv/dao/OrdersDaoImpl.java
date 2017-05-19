package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
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
    public List<Orders> findAllOrdersByState(OrdersState ordersState) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.ordersState = :ordersState")
                .setParameter("ordersState", ordersState)
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

    @Override
    public List<Orders> getTopBuyers(Integer numberOfTops) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> orders = query.from(Orders.class);

        query.multiselect(orders.get("user"), builder.sum(orders.get("totalPrice")));
        query.groupBy(orders.get("user"));
        query.orderBy(builder.desc(builder.sum(orders.get("totalPrice"))));

        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.notEqual(orders.get("ordersState"), OrdersState.Pending)));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        try {
            List<Orders> ordersList = super.getEntityManager().createQuery(query).setMaxResults(numberOfTops).getResultList();
            return ordersList != null ? ordersList : null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
