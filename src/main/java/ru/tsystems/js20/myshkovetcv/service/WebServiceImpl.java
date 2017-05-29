package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

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

        logger.debug("Getting list of products for storefront. Type of list: {}", storefrontType);
        return productDtoList;
    }
}
