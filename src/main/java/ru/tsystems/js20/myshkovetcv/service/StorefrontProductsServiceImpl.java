package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.StorefrontProductsDao;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.StorefrontProducts;
import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

import java.util.ArrayList;
import java.util.List;

@Service("storefrontProductsService")
@Transactional
public class StorefrontProductsServiceImpl implements StorefrontProductsService {

    @Autowired
    private StorefrontProductsDao storefrontProductsDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private StorefrontSettingsService storefrontSettingsService;
    @Autowired
    private JmsService jmsService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<ProductDto> getListOfProductsDto() {
        List<StorefrontProducts> allStorefrontProducts = storefrontProductsDao.getAllStorefrontProducts();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (StorefrontProducts storefrontProducts : allStorefrontProducts) {
            productDtoList.add(new ProductDto(storefrontProducts.getProduct()));
        }
        logger.debug("Getting custom list of products for storefront");
        return productDtoList;
    }

    @Override
    public void addProductToList(Long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            List<StorefrontProducts> storefrontProductsList = storefrontProductsDao.findByProduct(product);

            if (storefrontProductsList != null && storefrontProductsList.isEmpty()) {
                StorefrontProducts storefrontProducts = new StorefrontProducts();
                storefrontProducts.setProduct(product);
                storefrontProductsDao.save(storefrontProducts);
                logger.debug("Product with ID: {}, added to storefront custom list", productId);
                if (storefrontSettingsService.getStorefrontType() == StorefrontType.CustomList) {
                    jmsService.sendMessage("UPDATE");
                }
            }
        }
    }

    @Override
    public void removeProductFromList(Long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            List<StorefrontProducts> storefrontProductsList = product.getStorefrontProductsList();
            if (storefrontProductsList != null) {
                storefrontProductsList.clear();
                logger.debug("Product with ID: {}, removed from storefront custom list", productId);
                if (storefrontSettingsService.getStorefrontType() == StorefrontType.CustomList) {
                    jmsService.sendMessage("UPDATE");
                }
            }
        }
    }
}
