package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

public class UserAddressDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipCode")
    private Integer zipCode;

    @JsonProperty("street")
    private String street;

    @JsonProperty("apartmentNumber")
    private String apartmentNumber;

    public UserAddressDto() {
    }

    public UserAddressDto(UserAddress userAddress) {
        this.id = userAddress.getId();
        this.country = userAddress.getCountry();
        this.city = userAddress.getCity();
        this.zipCode = userAddress.getZipCode();
        this.street = userAddress.getStreet();
        this.apartmentNumber = userAddress.getApartmentNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
