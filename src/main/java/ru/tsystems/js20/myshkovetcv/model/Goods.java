package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String category; //TODO change type

    @Column
    private String parameters; //TODO change type

    @Column
    private Double weight;

    @Column
    private Double volume;

    @Column
    private Double stock;

    @ManyToMany(mappedBy = "goods")
    private List<Order> orders;

    public Goods() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (!getId().equals(goods.getId())) return false;
        if (getName() != null ? !getName().equals(goods.getName()) : goods.getName() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(goods.getPrice()) : goods.getPrice() != null)
            return false;
        if (getCategory() != null ? !getCategory().equals(goods.getCategory()) : goods.getCategory() != null)
            return false;
        if (getParameters() != null ? !getParameters().equals(goods.getParameters()) : goods.getParameters() != null)
            return false;
        if (getWeight() != null ? !getWeight().equals(goods.getWeight()) : goods.getWeight() != null)
            return false;
        if (getVolume() != null ? !getVolume().equals(goods.getVolume()) : goods.getVolume() != null)
            return false;
        if (getStock() != null ? !getStock().equals(goods.getStock()) : goods.getStock() != null)
            return false;
        return getOrders() != null ? getOrders().equals(goods.getOrders()) : goods.getOrders() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getParameters() != null ? getParameters().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getVolume() != null ? getVolume().hashCode() : 0);
        result = 31 * result + (getStock() != null ? getStock().hashCode() : 0);
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
