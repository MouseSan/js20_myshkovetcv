package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import ru.tsystems.js20.myshkovetcv.model.enums.UserRoles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 5165165165161566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @NotEmpty
    @Column(name = "emailAddress")
    private String emailAddress;

    @NotEmpty
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<UserRoles> userRoles = new HashSet<UserRoles>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserAddress> userAddressList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Orders> ordersList = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, Date dateOfBirth, String emailAddress, String userName, String password, Set<UserRoles> userRoles, List<UserAddress> userAddressList, List<Orders> ordersList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
        this.userRoles = userRoles;
        this.userAddressList = userAddressList;
        this.ordersList = ordersList;
    }

    public User(String firstName, String lastName, Date dateOfBirth, String emailAddress, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, Date dateOfBirth, String emailAddress, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public void addUserRole(UserRoles userRole) {
        this.userRoles.add(userRole);
    }

    public List<UserAddress> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(List<UserAddress> userAddressList) {
        this.userAddressList = userAddressList;
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

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(user.getDateOfBirth()) : user.getDateOfBirth() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(user.getEmailAddress()) : user.getEmailAddress() != null)
            return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
