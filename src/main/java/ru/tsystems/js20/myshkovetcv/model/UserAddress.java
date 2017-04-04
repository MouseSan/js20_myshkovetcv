package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 5165199995161566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "country", nullable = false)
    private String country;

    @NotEmpty
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "zipCode", nullable = false)
    private Integer zipCode;

    @NotEmpty
    @Column(name = "street", nullable = false)
    private String street;

    @NotEmpty
    @Column(name = "apartmentNumber", nullable = false)
    private String apartmentNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userAddress")
    private List<Orders> ordersList = new ArrayList<>();

    public UserAddress(String country, String city, Integer zipCode, String street, String apartmentNumber, User user, List<Orders> ordersList) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.user = user;
        this.ordersList = ordersList;
    }

    public UserAddress(String country, String city, Integer zipCode, String street, String apartmentNumber, User user) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.user = user;
    }

    public UserAddress() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        UserAddress that = (UserAddress) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null)
            return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null)
            return false;
        if (getZipCode() != null ? !getZipCode().equals(that.getZipCode()) : that.getZipCode() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(that.getStreet()) : that.getStreet() != null)
            return false;
        if (getApartmentNumber() != null ? !getApartmentNumber().equals(that.getApartmentNumber()) : that.getApartmentNumber() != null)
            return false;
        if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null)
            return false;
        return getOrdersList() != null ? getOrdersList().equals(that.getOrdersList()) : that.getOrdersList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getApartmentNumber() != null ? getApartmentNumber().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getOrdersList() != null ? getOrdersList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", user=" + user +
                '}';
    }
}
