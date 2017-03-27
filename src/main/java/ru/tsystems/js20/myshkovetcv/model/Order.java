package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ManyToOne
    private Customer customer;

    @Column
    @ManyToOne
    private CustomerAddress customerAddress;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "ordered_goods", joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "goods_id")})
    private List<Goods> goods;

    @Column
    private String paymentMethod; //TODO change type

    @Column
    private String deliveryMethod; //TODO change type

    @Column
    private String paymentState; //TODO change type

    @Column
    private String orderState; //TODO change type

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!getId().equals(order.getId())) return false;
        if (getCustomer() != null ? !getCustomer().equals(order.getCustomer()) : order.getCustomer() != null)
            return false;
        if (getCustomerAddress() != null ? !getCustomerAddress().equals(order.getCustomerAddress()) : order.getCustomerAddress() != null)
            return false;
        if (getGoods() != null ? !getGoods().equals(order.getGoods()) : order.getGoods() != null)
            return false;
        if (getPaymentMethod() != null ? !getPaymentMethod().equals(order.getPaymentMethod()) : order.getPaymentMethod() != null)
            return false;
        if (getDeliveryMethod() != null ? !getDeliveryMethod().equals(order.getDeliveryMethod()) : order.getDeliveryMethod() != null)
            return false;
        if (getPaymentState() != null ? !getPaymentState().equals(order.getPaymentState()) : order.getPaymentState() != null)
            return false;
        return getOrderState() != null ? getOrderState().equals(order.getOrderState()) : order.getOrderState() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getCustomerAddress() != null ? getCustomerAddress().hashCode() : 0);
        result = 31 * result + (getGoods() != null ? getGoods().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getDeliveryMethod() != null ? getDeliveryMethod().hashCode() : 0);
        result = 31 * result + (getPaymentState() != null ? getPaymentState().hashCode() : 0);
        result = 31 * result + (getOrderState() != null ? getOrderState().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}
