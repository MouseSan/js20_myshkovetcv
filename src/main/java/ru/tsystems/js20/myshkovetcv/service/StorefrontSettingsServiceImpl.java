package ru.tsystems.js20.myshkovetcv.service;

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

    @Override
    public ModelMap getStorefrontSettingsModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("storefrontSettingsDto", new StorefrontSettingsDto(getFirstStorefrontSettings()));
        modelMap.addAttribute("storefrontProductsList", storefrontProductsService.getListOfProductsDto());
        modelMap.addAttribute("listTopSoldProducts", soldProductInfoService.getTopSoldProducts(10));
        return modelMap;
    }

    @Override
    public void updateStorefrontSettings(StorefrontSettingsDto storefrontSettingsDto) {
        StorefrontSettings storefrontSettings = storefrontSettingsDao.findById(storefrontSettingsDto.getId());
        if (storefrontSettings != null) {
            storefrontSettings.setStorefrontType(storefrontSettingsDto.getStorefrontType());
            storefrontSettingsDao.updateStorefrontSettings(storefrontSettings);
        } else {

        }
    }

    private StorefrontSettings getFirstStorefrontSettings() {
        List<StorefrontSettings> storefrontSettingsList = storefrontSettingsDao.getStorefrontSettings();
        if (!storefrontSettingsList.isEmpty()) {
            return storefrontSettingsList.get(0);
        } else {
            StorefrontSettings storefrontSettings = new StorefrontSettings();
            storefrontSettings.setStorefrontType(StorefrontType.TopTenProducts);
            storefrontSettingsDao.save(storefrontSettings);
            return storefrontSettings;
        }
    }
}
