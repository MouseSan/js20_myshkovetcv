package ru.tsystems.js20.myshkovetcv.model;

import ru.tsystems.js20.myshkovetcv.model.enums.StorefrontType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storefrontSettings")
public class StorefrontSettings implements Serializable {

    private static final long serialVersionUID = 16516512827321654L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "storefront_type")
    @Enumerated(EnumType.STRING)
    private StorefrontType storefrontType;

    public StorefrontSettings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StorefrontType getStorefrontType() {
        return storefrontType;
    }

    public void setStorefrontType(StorefrontType storefrontType) {
        this.storefrontType = storefrontType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorefrontSettings that = (StorefrontSettings) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getStorefrontType() == that.getStorefrontType();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStorefrontType() != null ? getStorefrontType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StorefrontSettings{" +
                "id=" + id +
                ", storefrontType=" + storefrontType +
                '}';
    }
}
