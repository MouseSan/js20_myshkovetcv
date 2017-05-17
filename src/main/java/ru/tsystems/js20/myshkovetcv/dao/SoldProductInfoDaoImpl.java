package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.List;

@Repository("soldProductInfoDao")
public class SoldProductInfoDaoImpl extends AbstractDao<Long, SoldProductInfo> implements SoldProductInfoDao {

    @Override
    public void save(SoldProductInfo soldProductInfo) {
        persist(soldProductInfo);
    }

    @Override
    public void updateSoldProductInfo(SoldProductInfo soldProductInfo) {
        update(soldProductInfo);
    }

    @Override
    public List<SoldProductInfo> getListByOrderId(Orders orders) {
        List<SoldProductInfo> soldProductInfoList = getEntityManager()
                .createQuery("SELECT s FROM SoldProductInfo s WHERE s.orders = :orders")
                .setParameter("orders", orders)
                .getResultList();

        return soldProductInfoList;
    }
}
