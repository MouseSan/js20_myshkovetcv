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

    @ManyToMany
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> productList = new ArrayList<>();

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

    public Orders(User user, String deliveryAddress, List<Product> productList, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, PaymentState paymentState, OrdersState ordersState, Integer totalQuantity, Double totalPrice, Date dateOfOrder) {
        this.user = user;
        this.deliveryAddress = deliveryAddress;
        this.productList = productList;
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

    public Orders() {
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProductToList(Product product) {
        this.productList.add(product);
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
        if (getTotalQuantity() != null ? !getTotalQuantity().equals(orders.getTotalQuantity()) : orders.getTotalQuantity() != null)
            return false;
        return getTotalPrice() != null ? getTotalPrice().equals(orders.getTotalPrice()) : orders.getTotalPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getDeliveryAddress() != null ? getDeliveryAddress().hashCode() : 0);
        result = 31 * result + (getTotalQuantity() != null ? getTotalQuantity().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
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
                '}';
    }
}
