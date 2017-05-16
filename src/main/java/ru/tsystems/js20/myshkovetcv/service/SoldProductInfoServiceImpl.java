package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.SoldProductInfoDao;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

@Service("soldProductInfoService")
@Transactional
public class SoldProductInfoServiceImpl implements SoldProductInfoService{

    @Autowired
    private SoldProductInfoDao soldProductInfoDao;

    @Override
    public void saveSoldProductInfo(SoldProductInfo soldProductInfo) {
        soldProductInfoDao.save(soldProductInfo);
    }

    @Override
    public void updateSoldProductInfo(SoldProductInfo soldProductInfo) {
        soldProductInfoDao.updateSoldProductInfo(soldProductInfo);
    }
}
