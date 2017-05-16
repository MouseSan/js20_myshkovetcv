package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import java.util.Date;
import java.util.List;

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

    @JsonProperty("userDto")
    private UserDto userDto;

    @JsonProperty("paymentState")
    private PaymentState paymentState;

    @JsonProperty("ordersState")
    private OrdersState ordersState;

    @JsonProperty("productDtoList")
    private List<ProductDto> productDtoList;

    @JsonProperty("totalQuantity")
    private Integer totalQuantity;

    @JsonProperty("totalPrice")
    private Double totalPrice;

    @JsonProperty("dateOfOrder")
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date dateOfOrder;

    public OrdersDto() {
    }

    public OrdersDto(Long id, String deliveryAddress, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, String newAddressCountry, String newAddressCity, String newAddressStreet, String newAddressApartmentNumber, String newAddressZipCode, UserDto userDto, PaymentState paymentState, OrdersState ordersState, List<ProductDto> productDtoList, Integer totalQuantity, Double totalPrice, Date dateOfOrder) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.newAddressCountry = newAddressCountry;
        this.newAddressCity = newAddressCity;
        this.newAddressStreet = newAddressStreet;
        this.newAddressApartmentNumber = newAddressApartmentNumber;
        this.newAddressZipCode = newAddressZipCode;
        this.userDto = userDto;
        this.paymentState = paymentState;
        this.ordersState = ordersState;
        this.productDtoList = productDtoList;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.dateOfOrder = dateOfOrder;
    }

    public OrdersDto(Orders orders) {
        this.id = orders.getId();
        this.userDto = new UserDto(orders.getUser());
        this.deliveryAddress = orders.getDeliveryAddress();
        this.paymentMethod = orders.getPaymentMethod();
        this.deliveryMethod = orders.getDeliveryMethod();
        this.paymentState = orders.getPaymentState();
        this.ordersState = orders.getOrdersState();
        this.totalPrice = orders.getTotalPrice();
        this.totalQuantity = orders.getTotalQuantity();
        this.dateOfOrder = orders.getDateOfOrder();
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public OrdersState getOrdersState() {
        return ordersState;
    }

    public void setOrdersState(OrdersState ordersState) {
        this.ordersState = ordersState;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getNewDeliveryAddress() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNewAddressZipCode()).append(", ")
                .append(getNewAddressCountry()).append(", ")
                .append(getNewAddressCity()).append(", ")
                .append(getNewAddressStreet()).append(", ")
                .append(getNewAddressApartmentNumber()).append(".");
        return sb.toString();
    }
}
