package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.SoldProductInfoDao;
import ru.tsystems.js20.myshkovetcv.dto.SoldProductInfoDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.ArrayList;
import java.util.List;

@Service("soldProductInfoService")
@Transactional
public class SoldProductInfoServiceImpl implements SoldProductInfoService{

    @Autowired
    private SoldProductInfoDao soldProductInfoDao;
    @Autowired
    private NavBarService navBarService;
    @Autowired
    private OrdersService ordersService;

    @Override
    public void saveSoldProductInfo(SoldProductInfo soldProductInfo) {
        soldProductInfoDao.save(soldProductInfo);
    }

    @Override
    public void updateSoldProductInfo(SoldProductInfo soldProductInfo) {
        soldProductInfoDao.updateSoldProductInfo(soldProductInfo);
    }

    @Override
    public List<SoldProductInfo> getListOfSoldProductsByOrderId(Orders orders) {
        return soldProductInfoDao.getListByOrderId(orders);
    }

    @Override
    public List<SoldProductInfoDto> getTopSoldProducts(Integer numberOfTops) {
        List<SoldProductInfo> soldProductInfos = soldProductInfoDao.getTopSoldProducts(numberOfTops);
        List<SoldProductInfoDto> soldProductInfoDtos = new ArrayList<>();
        for (SoldProductInfo soldProductInfo : soldProductInfos) {
            soldProductInfoDtos.add(new SoldProductInfoDto(soldProductInfo.getProduct(),
                    soldProductInfo.getSoldQuantity()));
        }
        return soldProductInfoDtos;
    }

    @Override
    public ModelMap getReportsModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("listTopSoldProducts", getTopSoldProducts(10));
        modelMap.addAttribute("listTopBuyers", ordersService.getTopBuyers(10));
        return modelMap;
    }
}
