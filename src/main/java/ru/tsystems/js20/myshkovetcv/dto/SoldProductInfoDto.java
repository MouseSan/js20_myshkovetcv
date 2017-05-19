package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.SoldProductInfo;

public class SoldProductInfoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("productDto")
    private ProductDto productDto;

    @JsonProperty("ordersDto")
    private OrdersDto ordersDto;

    @JsonProperty("soldPrice")
    private Double soldPrice;

    @JsonProperty("soldQuantity")
    private Integer soldQuantity;

    public SoldProductInfoDto() {
    }

    public SoldProductInfoDto(Long id, ProductDto productDto, OrdersDto ordersDto, Double soldPrice, Integer soldQuantity) {
        this.id = id;
        this.productDto = productDto;
        this.ordersDto = ordersDto;
        this.soldPrice = soldPrice;
        this.soldQuantity = soldQuantity;
    }

    public SoldProductInfoDto(SoldProductInfo soldProductInfo) {
        this.id = soldProductInfo.getId();
        this.productDto = new ProductDto(soldProductInfo.getProduct());
        this.ordersDto = new OrdersDto(soldProductInfo.getOrders());
        this.soldPrice = soldProductInfo.getSoldPrice();
        this.soldQuantity = soldProductInfo.getSoldQuantity();
    }

    public SoldProductInfoDto(Product product, Integer soldQuantity) {
        this.productDto = new ProductDto(product);
        this.soldQuantity = soldQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public OrdersDto getOrdersDto() {
        return ordersDto;
    }

    public void setOrdersDto(OrdersDto ordersDto) {
        this.ordersDto = ordersDto;
    }

    public Double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}
