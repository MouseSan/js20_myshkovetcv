package ru.tsystems.js20.myshkovetcv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.tsystems.js20.myshkovetcv.model.Brand;

public class BrandDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public BrandDto() {
    }

    public BrandDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandDto(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandDto brandDto = (BrandDto) o;

        if (getId() != null ? !getId().equals(brandDto.getId()) : brandDto.getId() != null)
            return false;
        return getName() != null ? getName().equals(brandDto.getName()) : brandDto.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
