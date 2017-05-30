package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 5151595175365161566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty
    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orders")
    private List<SoldProductInfo> soldProductInfoList = new ArrayList<>();

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "delivery_method")
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @Column(name = "payment_state")
    @Enumerated(EnumType.STRING)
    private PaymentState paymentState;

    @Column(name = "orders_state")
    @Enumerated(EnumType.STRING)
    private OrdersState ordersState;

    @Column(name = "totalQuantity")
    private Integer totalQuantity;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateOfOrder")
    private Date dateOfOrder;

    public Orders(User user, String deliveryAddress, List<SoldProductInfo> soldProductInfoList, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrdersState ordersState, Integer totalQuantity, Double totalPrice, Date dateOfOrder) {
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.soldProductInfoList = soldProductInfoList;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.paymentState = paymentState;
        this.ordersState = ordersState;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.dateOfOrder = dateOfOrder;
    }

    public Orders(User user, String deliveryAddress, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrdersState ordersState, Integer totalQuantity, Double totalPrice, Date dateOfOrder) {
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.paymentState = paymentState;
        this.ordersState = ordersState;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.dateOfOrder = dateOfOrder;
    }

    public Orders(Long id, User user, String deliveryAddress, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrdersState ordersState, Integer totalQuantity, Double totalPrice, Date dateOfOrder) {
        this.id = id;
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.deliveryMethod = deliveryMethod;
        this.paymentState = paymentState;
        this.ordersState = ordersState;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.dateOfOrder = dateOfOrder;
    }

    public Orders() {
    }

    public Orders(User user, Double totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;
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

    public OrdersState getOrdersState() {
        return ordersState;
    }

    public void setOrdersState(OrdersState ordersState) {
        this.ordersState = ordersState;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public List<SoldProductInfo> getSoldProductInfoList() {
        return soldProductInfoList;
    }

    public void setSoldProductInfoList(List<SoldProductInfo> soldProductInfoList) {
        this.soldProductInfoList = soldProductInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (getId() != null ? !getId().equals(orders.getId()) : orders.getId() != null)
            return false;
        if (getUser() != null ? !getUser().equals(orders.getUser()) : orders.getUser() != null)
            return false;
        if (getDeliveryAddress() != null ? !getDeliveryAddress().equals(orders.getDeliveryAddress()) : orders.getDeliveryAddress() != null)
            return false;
        if (getPaymentMethod() != orders.getPaymentMethod()) return false;
        if (getDeliveryMethod() != orders.getDeliveryMethod()) return false;
        if (getPaymentState() != orders.getPaymentState()) return false;
        if (getOrdersState() != orders.getOrdersState()) return false;
        if (getTotalQuantity() != null ? !getTotalQuantity().equals(orders.getTotalQuantity()) : orders.getTotalQuantity() != null)
            return false;
        if (getTotalPrice() != null ? !getTotalPrice().equals(orders.getTotalPrice()) : orders.getTotalPrice() != null)
            return false;
        return getDateOfOrder() != null ? getDateOfOrder().equals(orders.getDateOfOrder()) : orders.getDateOfOrder() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getDeliveryAddress() != null ? getDeliveryAddress().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getDeliveryMethod() != null ? getDeliveryMethod().hashCode() : 0);
        result = 31 * result + (getPaymentState() != null ? getPaymentState().hashCode() : 0);
        result = 31 * result + (getOrdersState() != null ? getOrdersState().hashCode() : 0);
        result = 31 * result + (getTotalQuantity() != null ? getTotalQuantity().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
        result = 31 * result + (getDateOfOrder() != null ? getDateOfOrder().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", deliveryMethod=" + deliveryMethod +
                ", paymentState=" + paymentState +
                ", ordersState=" + ordersState +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", dateOfOrder=" + dateOfOrder +
                '}';
    }
}
