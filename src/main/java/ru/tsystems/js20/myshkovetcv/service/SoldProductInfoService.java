package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.SoldProductInfoDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

import java.util.List;

public interface SoldProductInfoService {

    void saveSoldProductInfo(SoldProductInfo soldProductInfo);

    List<SoldProductInfo> getListOfSoldProductsByOrderId(Orders orders);

    List<SoldProductInfoDto> getTopSoldProducts(Integer numberOfTops);

    ModelMap getReportsModel();
}
