package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

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
}
