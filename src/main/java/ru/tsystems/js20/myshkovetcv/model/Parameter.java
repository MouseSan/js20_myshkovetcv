package ru.tsystems.js20.myshkovetcv.model;

import javax.persistence.*;

public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long goods_id;

    @Column
    private String value;

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

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (!getId().equals(parameter.getId())) return false;
        if (getName() != null ? !getName().equals(parameter.getName()) : parameter.getName() != null)
            return false;
        if (getGoods_id() != null ? !getGoods_id().equals(parameter.getGoods_id()) : parameter.getGoods_id() != null)
            return false;
        return getValue() != null ? getValue().equals(parameter.getValue()) : parameter.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGoods_id() != null ? getGoods_id().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
