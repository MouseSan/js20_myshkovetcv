package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 165165165161566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @Column(name = "weight", nullable = false)
    private Double weight;

    @NotNull
    @Column(name = "volume", nullable = false)
    private Double volume;

    @NotNull
    @Column(name = "stock", nullable = false)
    private Double stock;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(name = "backlight", nullable = false)
    private boolean backlight;

    @Column(name = "clockFace")
    @Enumerated(EnumType.STRING)
    private ClockFaceType clockFace;

    @Column(name = "glass")
    @Enumerated(EnumType.STRING)
    private ClockGlassType glass;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column(name = "waterResistant")
    @Enumerated(EnumType.STRING)
    private WaterResistantType waterResistant;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<SoldProductInfo> soldProductInfoList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<StorefrontProducts> storefrontProductsList = new ArrayList<>();

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "imageId")
    private String imageId;

    public Product() {
    }

    public Product(String name, Double price, Category category, Double weight, Double volume, Double stock, Brand brand, boolean backlight, ClockFaceType clockFace, ClockGlassType glass, GenderType gender, WaterResistantType waterResistant, String description, List<SoldProductInfo> soldProductInfoList, List<StorefrontProducts> storefrontProductsList, String imageURL, String imageId) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.volume = volume;
        this.stock = stock;
        this.brand = brand;
        this.backlight = backlight;
        this.clockFace = clockFace;
        this.glass = glass;
        this.gender = gender;
        this.waterResistant = waterResistant;
        this.description = description;
        this.soldProductInfoList = soldProductInfoList;
        this.storefrontProductsList = storefrontProductsList;
        this.imageURL = imageURL;
        this.imageId = imageId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SoldProductInfo> getSoldProductInfoList() {
        return soldProductInfoList;
    }

    public void setSoldProductInfoList(List<SoldProductInfo> soldProductInfoList) {
        this.soldProductInfoList = soldProductInfoList;
    }

    public List<StorefrontProducts> getStorefrontProductsList() {
        return storefrontProductsList;
    }

    public void setStorefrontProductsList(List<StorefrontProducts> storefrontProductsList) {
        this.storefrontProductsList = storefrontProductsList;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (isBacklight() != product.isBacklight()) return false;
        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null)
            return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(product.getCategory()) : product.getCategory() != null)
            return false;
        if (getWeight() != null ? !getWeight().equals(product.getWeight()) : product.getWeight() != null)
            return false;
        if (getVolume() != null ? !getVolume().equals(product.getVolume()) : product.getVolume() != null)
            return false;
        if (getStock() != null ? !getStock().equals(product.getStock()) : product.getStock() != null)
            return false;
        if (getBrand() != null ? !getBrand().equals(product.getBrand()) : product.getBrand() != null)
            return false;
        if (getClockFace() != product.getClockFace()) return false;
        if (getGlass() != product.getGlass()) return false;
        if (getGender() != product.getGender()) return false;
        if (getWaterResistant() != product.getWaterResistant()) return false;
        return getDescription() != null ? getDescription().equals(product.getDescription()) : product.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getVolume() != null ? getVolume().hashCode() : 0);
        result = 31 * result + (getStock() != null ? getStock().hashCode() : 0);
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (isBacklight() ? 1 : 0);
        result = 31 * result + (getClockFace() != null ? getClockFace().hashCode() : 0);
        result = 31 * result + (getGlass() != null ? getGlass().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getWaterResistant() != null ? getWaterResistant().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", weight=" + weight +
                ", volume=" + volume +
                ", stock=" + stock +
                ", brand=" + brand +
                ", backlight=" + backlight +
                ", clockFace=" + clockFace +
                ", glass=" + glass +
                ", gender=" + gender +
                ", waterResistant=" + waterResistant +
                ", description='" + description + '\'' +
                '}';
    }
}
