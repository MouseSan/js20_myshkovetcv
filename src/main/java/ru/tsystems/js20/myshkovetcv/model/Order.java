package ru.tsystems.js20.myshkovetcv.model;

import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrderState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 515151165161566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "userAddress_id")
    private UserAddress userAddress;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> productList;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "delivery_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;


    @Column(name = "payment_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentState paymentState;

    @Column(name = "order_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public Order(User user, UserAddress userAddress, List<Product> productList, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrderState orderState) {
        this.user = user;
        this.userAddress = userAddress;
        this.productList = productList;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.paymentState = paymentState;
        this.orderState = orderState;
    }

    public Order(User user, UserAddress userAddress, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrderState orderState) {
        this.user = user;
        this.userAddress = userAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.paymentState = paymentState;
        this.orderState = orderState;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (getUser() != null ? !getUser().equals(order.getUser()) : order.getUser() != null)
            return false;
        if (getUserAddress() != null ? !getUserAddress().equals(order.getUserAddress()) : order.getUserAddress() != null)
            return false;
        if (getProductList() != null ? !getProductList().equals(order.getProductList()) : order.getProductList() != null)
            return false;
        if (getPaymentMethod() != order.getPaymentMethod()) return false;
        if (getDeliveryMethod() != order.getDeliveryMethod()) return false;
        if (getPaymentState() != order.getPaymentState()) return false;
        return getOrderState() == order.getOrderState();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getUserAddress() != null ? getUserAddress().hashCode() : 0);
        result = 31 * result + (getProductList() != null ? getProductList().hashCode() : 0);
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
                ", user=" + user +
                ", userAddress=" + userAddress +
                ", productList=" + productList +
                '}';
    }
}
