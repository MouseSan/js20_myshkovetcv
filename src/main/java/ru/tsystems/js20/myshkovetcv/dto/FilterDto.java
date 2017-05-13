package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

public class FilterDto {

    @JsonProperty("sorting")
    private String sorting;

    @JsonProperty("categoryDto")
    private CategoryDto categoryDto;

    @JsonProperty("brandDto")
    private BrandDto brandDto;

    @JsonProperty("backlight")
    private String backlight;

    @JsonProperty("clockFace")
    private ClockFaceType clockFace;

    @JsonProperty("glass")
    private ClockGlassType glass;

    @JsonProperty("gender")
    private GenderType gender;

    @JsonProperty("waterResistant")
    private WaterResistantType waterResistant;

    public FilterDto(String sorting, CategoryDto categoryDto, BrandDto brandDto, String backlight, ClockFaceType clockFace, ClockGlassType glass, GenderType gender, WaterResistantType waterResistant) {
        this.sorting = sorting;
        this.categoryDto = categoryDto;
        this.brandDto = brandDto;
        this.backlight = backlight;
        this.clockFace = clockFace;
        this.glass = glass;
        this.gender = gender;
        this.waterResistant = waterResistant;
    }

    public FilterDto() {
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
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

    public String getBacklight() {
        return backlight;
    }

    public void setBacklight(String backlight) {
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
