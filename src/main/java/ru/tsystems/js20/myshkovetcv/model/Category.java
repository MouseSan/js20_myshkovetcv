package ru.tsystems.js20.myshkovetcv.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    private static final long serialVersionUID = 1651651232446L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "category_parameter",
//            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "parameter_id", referencedColumnName = "id")
//    )
//    private List<Parameter> parameterList = new ArrayList<>();


    public Category(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProductToList(Product product) {
        this.productList.add(product);
    }

//    public List<Parameter> getParameterList() {
//        return parameterList;
//    }
//
//    public void setParameterList(List<Parameter> parameterList) {
//        this.parameterList = parameterList;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (getId() != null ? !getId().equals(category.getId()) : category.getId() != null)
            return false;
        if (getName() != null ? !getName().equals(category.getName()) : category.getName() != null)
            return false;
        return getProductList() != null ? getProductList().equals(category.getProductList()) : category.getProductList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getProductList() != null ? getProductList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
