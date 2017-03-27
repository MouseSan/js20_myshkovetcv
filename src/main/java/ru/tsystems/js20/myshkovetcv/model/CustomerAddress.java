package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private Integer zipCode;

    @Column
    private String street;

    @Column
    private String apartmentNumber;

    @OneToMany(mappedBy = "customerAddress")
    private List<Order> orders;

    @OneToOne(mappedBy = "customerAddress")
    private Customer customer;

    public CustomerAddress() {
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (!getId().equals(that.getId())) return false;
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
        if (getOrders() != null ? !getOrders().equals(that.getOrders()) : that.getOrders() != null)
            return false;
        return getCustomer() != null ? getCustomer().equals(that.getCustomer()) : that.getCustomer() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getApartmentNumber() != null ? getApartmentNumber().hashCode() : 0);
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
