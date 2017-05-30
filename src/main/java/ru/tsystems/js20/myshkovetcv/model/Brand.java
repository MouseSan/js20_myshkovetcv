package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1651651282736432446L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand")
    private List<Product> productList = new ArrayList<>();

    public Brand() {
    }

    public Brand(Long id, String name) {
        this.id = id;
        this.productList = productList;
    }

    public Brand(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addToProductList(Product product) {
        this.productList.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (id != null ? !id.equals(brand.id) : brand.id != null) return false;
        return name != null ? name.equals(brand.name) : brand.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
