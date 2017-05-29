package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository("soldProductInfoDao")
public class SoldProductInfoDaoImpl extends AbstractDao<Long, SoldProductInfo> implements SoldProductInfoDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void save(SoldProductInfo soldProductInfo) {
        persist(soldProductInfo);
        logger.debug("Sold product info saved: {}", soldProductInfo.getId());
    }

    @Override
    public List<SoldProductInfo> getListByOrderId(Orders orders) {
        List<SoldProductInfo> soldProductInfoList = getEntityManager()
                .createQuery("SELECT s FROM SoldProductInfo s WHERE s.orders = :orders")
                .setParameter("orders", orders)
                .getResultList();
        logger.debug("Get list of sold product info by order ID: {}", orders.getId());
        return soldProductInfoList;
    }

    @Override
    public List<SoldProductInfo> getTopSoldProducts(Integer numberOfTops) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<SoldProductInfo> query = builder.createQuery(SoldProductInfo.class);
        Root<SoldProductInfo> soldProduct = query.from(SoldProductInfo.class);

        Join<SoldProductInfo, Orders> orders = soldProduct.join("orders");

        query.multiselect(soldProduct.get("product"), builder.sum(soldProduct.get("soldQuantity")));
        query.groupBy(soldProduct.get("product"));
        query.orderBy(builder.desc(builder.sum(soldProduct.get("soldQuantity"))));

        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.notEqual(orders.get("ordersState"), OrdersState.Pending)));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        try {
            List<SoldProductInfo> soldProductInfos = super.getEntityManager().createQuery(query).setMaxResults(numberOfTops).getResultList();
            if (soldProductInfos != null) {
                logger.debug("List of top {} sold product found", numberOfTops);
                return soldProductInfos;
            } else {
                logger.debug("List of top {} sold product not found", numberOfTops);
                return new ArrayList<>();
            }
        } catch (NoResultException e) {
            logger.warn("List of top {} sold product not found", numberOfTops);
            return new ArrayList<>();
        }
    }
}
