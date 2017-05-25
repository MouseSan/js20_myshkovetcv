package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.StorefrontSettings;
import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

public class StorefrontSettingsDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("storefrontType")
    private StorefrontType storefrontType;

    public StorefrontSettingsDto(StorefrontSettings storefrontSettings) {
        this.id = storefrontSettings.getId();
        this.storefrontType = storefrontSettings.getStorefrontType();
    }

    public StorefrontSettingsDto(Long id, StorefrontType storefrontType) {
        this.id = id;
        this.storefrontType = storefrontType;
    }

    public StorefrontSettingsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StorefrontType getStorefrontType() {
        return storefrontType;
    }

    public void setStorefrontType(StorefrontType storefrontType) {
        this.storefrontType = storefrontType;
    }
}
