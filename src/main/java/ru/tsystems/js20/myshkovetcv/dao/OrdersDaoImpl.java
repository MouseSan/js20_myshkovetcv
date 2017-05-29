package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.service.DateService;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository("ordersDao")
public class OrdersDaoImpl extends AbstractDao<Long, Orders> implements OrdersDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Orders findById(Long id) {
        logger.debug("Getting order by id: {}", id);
        return getByKey(id);
    }

    @Override
    public void save(Orders orders) {
        persist(orders);
        logger.debug("Order saved: {}", orders.getId());
    }

    @Override
    public void updateOrders(Orders orders) {
        update(orders);
        logger.debug("Order updated: {}", orders.getId());
    }

    @Override
    public List<Orders> findAllOrders() {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o ORDER BY o.id ASC")
                .getResultList();
        logger.debug("Get list of all orders");
        return ordersList;
    }

    @Override
    public List<Orders> findAllOrdersByUser(User user) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.user = :user")
                .setParameter("user", user)
                .getResultList();
        logger.debug("Get list of all orders by user: {}", user.getUserName());
        return ordersList;
    }

    @Override
    public List<Orders> findAllOrdersByState(OrdersState ordersState) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.ordersState = :ordersState")
                .setParameter("ordersState", ordersState)
                .getResultList();
        logger.debug("Get list of all orders by order state: {}", ordersState);
        return ordersList;
    }

    @Override
    public List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState) {
        List<Orders> ordersList = getEntityManager()
                .createQuery("SELECT o FROM Orders o WHERE o.user = :user AND o.ordersState = :ordersState")
                .setParameter("user", user)
                .setParameter("ordersState", ordersState)
                .getResultList();
        logger.debug("Get list of all orders by order state: {} and user: {}", ordersState, user.getUserName());
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

            if (ordersList != null) {
                logger.debug("List of top {} buyers found", numberOfTops);
                return ordersList;
            } else {
                logger.warn("List of top {} buyers not found", numberOfTops);
                return new ArrayList<>();
            }
        } catch (NoResultException e) {
            logger.warn("List of top {} buyers not found", numberOfTops);
            return new ArrayList<>();
        }
    }

    @Override
    public List<Orders> findAllOrdersForLastMonth() {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Orders> query = builder.createQuery(Orders.class);
        Root<Orders> orders = query.from(Orders.class);

        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.notEqual(orders.get("ordersState"), OrdersState.Pending)));
        predList.add(builder.and(builder.greaterThan(orders.get("dateOfOrder"), DateService.getDateMonthAgo())));

        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        try {
            List<Orders> ordersList = super.find(query);

            if (ordersList != null) {
                logger.debug("List of all orders for last month found");
                return ordersList;
            } else {
                logger.warn("List of all orders for last month not found");
                return new ArrayList<>();
            }
        } catch (NoResultException e) {
            logger.warn("List of all orders for last month not found");
            return new ArrayList<>();
        }
    }
}
