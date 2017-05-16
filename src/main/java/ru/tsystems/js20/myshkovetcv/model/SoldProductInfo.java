package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "soldProductInfo")
public class SoldProductInfo implements Serializable {

    private static final long serialVersionUID = 8951595151884947176L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @Column(name = "soldPrice")
    private Double soldPrice;

    @Column(name = "soldQuantity")
    private Integer soldQuantity;

    public SoldProductInfo() {
    }

    public SoldProductInfo(Product product, Orders orders, Double soldPrice, Integer soldQuantity) {
        this.product = product;
        this.orders = orders;
        this.soldPrice = soldPrice;
        this.soldQuantity = soldQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldProductInfo that = (SoldProductInfo) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SoldProductInfo{" +
                "id=" + id +
                ", product=" + product +
                ", orders=" + orders +
                ", soldPrice=" + soldPrice +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
