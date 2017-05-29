package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.List;

public interface SoldProductInfoDao {

    void save(SoldProductInfo soldProductInfo);

    List<SoldProductInfo> getListByOrderId(Orders orders);

    List<SoldProductInfo> getTopSoldProducts(Integer numberOfTops);
}
