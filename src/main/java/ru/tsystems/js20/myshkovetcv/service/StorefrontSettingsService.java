package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.StorefrontSettingsDto;
import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

public interface StorefrontSettingsService {

    ModelMap getStorefrontSettingsModel();

    void updateStorefrontSettings(StorefrontSettingsDto storefrontSettingsDto);

    StorefrontSettingsDto getStorefrontSettingsDto();

    StorefrontType getStorefrontType();
}
