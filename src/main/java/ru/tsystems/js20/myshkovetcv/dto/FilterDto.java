package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

public class FilterDto {

    @JsonProperty("brandDto")
    private BrandDto brandDto;

    @JsonProperty("backlight")
    private boolean backlight;

    @JsonProperty("clockFace")
    private ClockFaceType clockFace;

    @JsonProperty("glass")
    private ClockGlassType glass;

    @JsonProperty("gender")
    private GenderType gender;

    @JsonProperty("waterResistant")
    private WaterResistantType waterResistant;

    public FilterDto(BrandDto brandDto, boolean backlight, ClockFaceType clockFace, ClockGlassType glass, GenderType gender, WaterResistantType waterResistant) {
        this.brandDto = brandDto;
        this.backlight = backlight;
        this.clockFace = clockFace;
        this.glass = glass;
        this.gender = gender;
        this.waterResistant = waterResistant;
    }

    public FilterDto() {
    }

    public ClockGlassType getGlass() {
        return glass;
    }

    public void setGlass(ClockGlassType glass) {
        this.glass = glass;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public void setBacklight(boolean backlight) {
        this.backlight = backlight;
    }

    public ClockFaceType getClockFace() {
        return clockFace;
    }

    public void setClockFace(ClockFaceType clockFace) {
        this.clockFace = clockFace;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public WaterResistantType getWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(WaterResistantType waterResistant) {
        this.waterResistant = waterResistant;
    }
}
