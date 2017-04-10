package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;

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
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(name = "product_parameterValue",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "parameterValue_id", referencedColumnName = "id")
    )
    private List<ParameterValue> parameterValueList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "productList")
    private List<Orders> ordersList = new ArrayList<>();

    @NotNull
    @Column(name = "weight", nullable = false)
    private Double weight;

    @NotNull
    @Column(name = "volume", nullable = false)
    private Double volume;

    @NotNull
    @Column(name = "stock", nullable = false)
    private Double stock;

    public Product(String name, Double price, Category category, List<ParameterValue> parameterValueList, List<Orders> ordersList, Double weight, Double volume, Double stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.parameterValueList = parameterValueList;
        this.ordersList = ordersList;
        this.weight = weight;
        this.volume = volume;
        this.stock = stock;
    }

    public Product(String name, Double price, Category category, Double weight, Double volume, Double stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.volume = volume;
        this.stock = stock;
    }

    public Product() {
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

    public List<ParameterValue> getParameterValueList() {
        return parameterValueList;
    }

    public void setParameterValueList(List<ParameterValue> parameterValueList) {
        this.parameterValueList = parameterValueList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null)
            return false;
        return getName() != null ? getName().equals(product.getName()) : product.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", stock=" + stock +
                '}';
    }
}
