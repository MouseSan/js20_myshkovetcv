package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.StorefrontSettings;

import java.util.List;

@Repository("storefrontSettingsDao")
public class StorefrontSettingsDaoImpl extends AbstractDao<Long, StorefrontSettings> implements StorefrontSettingsDao {

    @Override
    public StorefrontSettings findById(Long id) {
        return getByKey(id);
    }

    @Override
    public List<StorefrontSettings> getStorefrontSettings() {
        List<StorefrontSettings> storefrontSettingsList = getEntityManager()
                .createQuery("SELECT s FROM StorefrontSettings s ORDER BY s.id ASC")
                .getResultList();
        return storefrontSettingsList;
    }

    @Override
    public void save(StorefrontSettings storefrontSettings) {
        persist(storefrontSettings);
    }

    @Override
    public void updateStorefrontSettings(StorefrontSettings storefrontSettings) {
        update(storefrontSettings);
    }
}
