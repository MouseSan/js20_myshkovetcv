package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.dto.SoldProductInfoDto;

import java.util.ArrayList;
import java.util.List;

@Service("webService")
@Transactional
public class WebServiceImpl implements WebService {

    @Autowired
    private SoldProductInfoService soldProductInfoService;

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<SoldProductInfoDto> topSoldProducts = soldProductInfoService.getTopSoldProducts(10);
        for (SoldProductInfoDto soldProductInfoDto : topSoldProducts) {
            productDtoList.add(soldProductInfoDto.getProductDto());
        }
        return productDtoList;
    }

}
