package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;
import ru.tsystems.js20.myshkovetcv.model.enums.ParameterType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parameter")
public class Parameter implements Serializable {

    private static final long serialVersionUID = 516516777771566L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ParameterType type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parameter")
    private List<ParameterValue> parameterValueList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "parameterList")
    private List<Category> categoryList = new ArrayList<>();

    public Parameter(String name, ParameterType type, List<ParameterValue> parameterValueList, List<Category> categoryList) {
        this.name = name;
        this.type = type;
        this.parameterValueList = parameterValueList;
        this.categoryList = categoryList;
    }

    public Parameter(String name, ParameterType type) {
        this.name = name;
        this.type = type;
    }

    public Parameter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParameterType getType() {
        return type;
    }

    public void setType(ParameterType type) {
        this.type = type;
    }

    public List<ParameterValue> getParameterValueList() {
        return parameterValueList;
    }

    public void setParameterValueList(List<ParameterValue> parameterValueList) {
        this.parameterValueList = parameterValueList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (getId() != null ? !getId().equals(parameter.getId()) : parameter.getId() != null)
            return false;
        if (getName() != null ? !getName().equals(parameter.getName()) : parameter.getName() != null)
            return false;
        if (getType() != parameter.getType()) return false;
        if (getParameterValueList() != null ? !getParameterValueList().equals(parameter.getParameterValueList()) : parameter.getParameterValueList() != null)
            return false;
        return getCategoryList() != null ? getCategoryList().equals(parameter.getCategoryList()) : parameter.getCategoryList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getParameterValueList() != null ? getParameterValueList().hashCode() : 0);
        result = 31 * result + (getCategoryList() != null ? getCategoryList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
