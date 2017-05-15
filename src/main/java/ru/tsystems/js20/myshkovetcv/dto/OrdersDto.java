package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;

public class OrdersDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @JsonProperty("paymentMethod")
    private PaymentMethod paymentMethod;

    @JsonProperty("deliveryMethod")
    private DeliveryMethod deliveryMethod;

    @JsonProperty("newAddressCountry")
    private String newAddressCountry;

    @JsonProperty("newAddressCity")
    private String newAddressCity;

    @JsonProperty("newAddressStreet")
    private String newAddressStreet;

    @JsonProperty("newAddressApartmentNumber")
    private String newAddressApartmentNumber;

    @JsonProperty("newAddressZipCode")
    private String newAddressZipCode;

    public OrdersDto() {
    }

    public OrdersDto(Long id, String deliveryAddress, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, String newAddressCountry, String newAddressCity, String newAddressStreet, String newAddressApartmentNumber, String newAddressZipCode) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.newAddressCountry = newAddressCountry;
        this.newAddressCity = newAddressCity;
        this.newAddressStreet = newAddressStreet;
        this.newAddressApartmentNumber = newAddressApartmentNumber;
        this.newAddressZipCode = newAddressZipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getNewAddressCountry() {
        return newAddressCountry;
    }

    public void setNewAddressCountry(String newAddressCountry) {
        this.newAddressCountry = newAddressCountry;
    }

    public String getNewAddressCity() {
        return newAddressCity;
    }

    public void setNewAddressCity(String newAddressCity) {
        this.newAddressCity = newAddressCity;
    }

    public String getNewAddressStreet() {
        return newAddressStreet;
    }

    public void setNewAddressStreet(String newAddressStreet) {
        this.newAddressStreet = newAddressStreet;
    }

    public String getNewAddressApartmentNumber() {
        return newAddressApartmentNumber;
    }

    public void setNewAddressApartmentNumber(String newAddressApartmentNumber) {
        this.newAddressApartmentNumber = newAddressApartmentNumber;
    }

    public String getNewAddressZipCode() {
        return newAddressZipCode;
    }

    public void setNewAddressZipCode(String newAddressZipCode) {
        this.newAddressZipCode = newAddressZipCode;
    }
}
