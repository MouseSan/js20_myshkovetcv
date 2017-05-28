package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.dto.SoldProductInfoDto;
import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

import java.util.ArrayList;
import java.util.List;

@Service("webService")
@Transactional
public class WebServiceImpl implements WebService {

    @Autowired
    private SoldProductInfoService soldProductInfoService;
    @Autowired
    private StorefrontSettingsService storefrontSettingsService;
    @Autowired
    private StorefrontProductsService storefrontProductsService;

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();

        StorefrontType storefrontType = storefrontSettingsService.getStorefrontType();
        if (storefrontType == StorefrontType.TopTenProducts) {

            List<SoldProductInfoDto> topSoldProducts = soldProductInfoService.getTopSoldProducts(10);
            for (SoldProductInfoDto soldProductInfoDto : topSoldProducts) {
                productDtoList.add(soldProductInfoDto.getProductDto());
            }
        } else if (storefrontType == StorefrontType.CustomList) {
            productDtoList = storefrontProductsService.getListOfProductsDto();
        }
        return productDtoList;
    }
}
