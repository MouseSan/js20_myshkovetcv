package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

public interface SoldProductInfoService {

    void saveSoldProductInfo(SoldProductInfo soldProductInfo);

    void updateSoldProductInfo(SoldProductInfo soldProductInfo);
}
