package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parameterValue")
public class ParameterValue implements Serializable {

    private static final long serialVersionUID = 777516777771566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parameter parameter;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "parameterValueList")
    private List<Product> productList = new ArrayList<>();

    public ParameterValue(String value, Parameter parameter, List<Product> productList) {
        this.value = value;
        this.parameter = parameter;
        this.productList = productList;
    }

    public ParameterValue(String value, Parameter parameter) {
        this.value = value;
        this.parameter = parameter;
    }

    public ParameterValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterValue that = (ParameterValue) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
            return false;
        if (getParameter() != null ? !getParameter().equals(that.getParameter()) : that.getParameter() != null)
            return false;
        return getProductList() != null ? getProductList().equals(that.getProductList()) : that.getProductList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getParameter() != null ? getParameter().hashCode() : 0);
        result = 31 * result + (getProductList() != null ? getProductList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ParameterValue{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", parameter=" + parameter +
                '}';
    }
}
