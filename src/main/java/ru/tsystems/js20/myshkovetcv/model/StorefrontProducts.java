package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storefrontProducts")
public class StorefrontProducts implements Serializable {

    private static final long serialVersionUID = 1632187282736432446L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    public StorefrontProducts() {
    }

    public StorefrontProducts(Long id, Product product) {
        this.id = id;
        this.product = product;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorefrontProducts that = (StorefrontProducts) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StorefrontProducts{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
