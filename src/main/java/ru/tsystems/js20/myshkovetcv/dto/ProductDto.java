package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

public class ProductDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("categoryDto")
    private CategoryDto categoryDto;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("volume")
    private Double volume;

    @JsonProperty("stock")
    private Double stock;

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

    @JsonProperty("description")
    private String description;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categoryDto = new CategoryDto(product.getCategory());
        this.weight = product.getWeight();
        this.volume = product.getVolume();
        this.stock = product.getStock();
        this.brandDto = new BrandDto(product.getBrand());
        this.backlight = product.isBacklight();
        this.clockFace= product.getClockFace();
        this.glass = product.getGlass();
        this.gender = product.getGender();
        this.waterResistant = product.getWaterResistant();
        this.description = product.getDescription();
    }

    public ProductDto(Long id, String name, Double price, CategoryDto categoryDto, Double weight, Double volume, Double stock, BrandDto brandDto, boolean backlight, ClockFaceType clockFace, ClockGlassType glass, GenderType gender, WaterResistantType waterResistant, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryDto = categoryDto;
        this.weight = weight;
        this.volume = volume;
        this.stock = stock;
        this.brandDto = brandDto;
        this.backlight = backlight;
        this.clockFace = clockFace;
        this.glass = glass;
        this.gender = gender;
        this.waterResistant = waterResistant;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
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

    public ClockGlassType getGlass() {
        return glass;
    }

    public void setGlass(ClockGlassType glass) {
        this.glass = glass;
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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
