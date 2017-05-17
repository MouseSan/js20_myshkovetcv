package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.List;

public interface SoldProductInfoService {

    void saveSoldProductInfo(SoldProductInfo soldProductInfo);

    void updateSoldProductInfo(SoldProductInfo soldProductInfo);

    List<SoldProductInfo> getListOfSoldProductsByOrderId(Orders orders);
}
