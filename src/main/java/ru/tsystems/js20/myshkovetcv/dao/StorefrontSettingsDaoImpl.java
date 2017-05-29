package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.StorefrontSettings;

import java.util.List;

@Repository("storefrontSettingsDao")
public class StorefrontSettingsDaoImpl extends AbstractDao<Long, StorefrontSettings> implements StorefrontSettingsDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public StorefrontSettings findById(Long id) {
        logger.debug("Getting storefront setting by id: {}", id);
        return getByKey(id);
    }

    @Override
    public List<StorefrontSettings> getStorefrontSettings() {
        List<StorefrontSettings> storefrontSettingsList = getEntityManager()
                .createQuery("SELECT s FROM StorefrontSettings s ORDER BY s.id ASC")
                .getResultList();
        logger.debug("Get list of all storefront settings");
        return storefrontSettingsList;
    }

    @Override
    public void save(StorefrontSettings storefrontSettings) {
        persist(storefrontSettings);
        logger.debug("Storefront settings saved: {}", storefrontSettings.getId());
    }

    @Override
    public void updateStorefrontSettings(StorefrontSettings storefrontSettings) {
        update(storefrontSettings);
        logger.debug("Storefront settings updated: {}", storefrontSettings.getId());
    }
}
