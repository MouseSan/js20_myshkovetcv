package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.StorefrontSettingsDao;
import ru.tsystems.js20.myshkovetcv.dto.StorefrontSettingsDto;
import ru.tsystems.js20.myshkovetcv.model.StorefrontSettings;
import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

import java.util.List;

@Service("storefrontSettingsService")
@Transactional
public class StorefrontSettingsServiceImpl implements StorefrontSettingsService {

    @Autowired
    private StorefrontSettingsDao storefrontSettingsDao;
    @Autowired
    private NavBarService navBarService;
    @Autowired
    private StorefrontProductsService storefrontProductsService;
    @Autowired
    private SoldProductInfoService soldProductInfoService;
    @Autowired
    private JmsService jmsService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelMap getStorefrontSettingsModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("storefrontSettingsDto", getStorefrontSettingsDto());
        modelMap.addAttribute("storefrontProductsList", storefrontProductsService.getListOfProductsDto());
        modelMap.addAttribute("listTopSoldProducts", soldProductInfoService.getTopSoldProducts(10));
        logger.debug("Storefront settings model formed");
        return modelMap;
    }

    @Override
    public void updateStorefrontSettings(StorefrontSettingsDto storefrontSettingsDto) {
        StorefrontSettings storefrontSettings = storefrontSettingsDao.findById(storefrontSettingsDto.getId());
        if (storefrontSettings != null) {
            storefrontSettings.setStorefrontType(storefrontSettingsDto.getStorefrontType());
            storefrontSettingsDao.updateStorefrontSettings(storefrontSettings);
            logger.debug("Storefront settings updated");
            jmsService.sendMessage("UPDATE");
        }
    }

    @Override
    public StorefrontSettingsDto getStorefrontSettingsDto() {
        List<StorefrontSettings> storefrontSettingsList = storefrontSettingsDao.getStorefrontSettings();
        if (!storefrontSettingsList.isEmpty()) {
            logger.debug("Storefront settings found");
            return new StorefrontSettingsDto(storefrontSettingsList.get(0));
        } else {
            logger.debug("Storefront settings not found, create new with TopTenProducts type");
            StorefrontSettings storefrontSettings = new StorefrontSettings();
            storefrontSettings.setStorefrontType(StorefrontType.TopTenProducts);
            storefrontSettingsDao.save(storefrontSettings);
            return new StorefrontSettingsDto(storefrontSettings);
        }
    }

    @Override
    public StorefrontType getStorefrontType() {
        StorefrontSettingsDto storefrontSettingsDto = getStorefrontSettingsDto();
        if (storefrontSettingsDto != null) {
            logger.debug("Storefront type found");
            return storefrontSettingsDto.getStorefrontType();
        } else {
            logger.debug("Storefront type not found, return TopTenProducts");
            return StorefrontType.TopTenProducts;
        }
    }
}
