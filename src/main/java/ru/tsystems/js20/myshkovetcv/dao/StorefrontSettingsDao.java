package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.StorefrontSettings;

import java.util.List;

public interface StorefrontSettingsDao {

    StorefrontSettings findById(Long id);

    List<StorefrontSettings> getStorefrontSettings();

    void save(StorefrontSettings storefrontSettings);

    void updateStorefrontSettings(StorefrontSettings storefrontSettings);

}
