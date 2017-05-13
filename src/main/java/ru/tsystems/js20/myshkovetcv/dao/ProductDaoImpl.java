package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.dto.FilterDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Long, Product> implements ProductDao {

    @Override
    public Product findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Product findByName(String name) {
        try {
            Product product = (Product) getEntityManager()
                    .createQuery("SELECT p FROM Product p WHERE p.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();

            return product;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        persist(product);
    }

    public void updateProduct(Product product) {
        update(product);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> productList = getEntityManager()
                .createQuery("SELECT p FROM Product p ORDER BY p.name ASC")
                .getResultList();
        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        List<Product> productList = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.category = :category")
                .setParameter("category", category)
                .getResultList();

        return productList;
    }

    @Override
    public Product findByParameters(String name, Category category, Double weight, Double volume,
                                    Brand brand, boolean backlight, ClockFaceType clockFace,
                                    ClockGlassType glass, GenderType gender,
                                    WaterResistantType waterResistant) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.distinct(true).from(Product.class);

        Join<Product, Brand> brands = product.join("brand");
        Join<Product, Category> categories = product.join("category");

        // Setting filters
        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.equal(product.get("name"), name)));
        predList.add(builder.and(builder.equal(categories.get("id"), category.getId())));
        predList.add(builder.and(builder.equal(product.get("weight"), weight)));
        predList.add(builder.and(builder.equal(product.get("volume"), volume)));
        predList.add(builder.and(builder.equal(brands.get("id"), brand.getId())));
        predList.add(builder.and(builder.equal(product.get("backlight"), backlight)));
        predList.add(builder.and(builder.equal(product.get("clockFace"), clockFace)));
        predList.add(builder.and(builder.equal(product.get("glass"), glass)));
        predList.add(builder.and(builder.equal(product.get("gender"), gender)));
        predList.add(builder.and(builder.equal(product.get("waterResistant"), waterResistant)));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        try {
            Product existingProduct = super.findOne(query);
            return existingProduct != null ? existingProduct : null;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Product> findByFilter(FilterDto filterDto) {
        CriteriaBuilder builder = super.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> product = query.distinct(true).from(Product.class);

        Join<Product, Brand> brands = product.join("brand");
        Join<Product, Category> categories = product.join("category");

        // Setting filters
        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.and(builder.equal(categories.get("id"), filterDto.getCategoryDto().getId())));
        if (filterDto.getBacklight().equals("true")) {
            predList.add(builder.and(builder.equal(product.get("backlight"), true)));
        } else if (filterDto.getBacklight().equals("false")) {
            predList.add(builder.and(builder.equal(product.get("backlight"), false)));
        }
        if (filterDto.getBrandDto() != null) {
            predList.add(builder.and(builder.equal(brands.get("id"), filterDto.getBrandDto().getId())));
        }
        if (filterDto.getClockFace() != null) {
            predList.add(builder.and(builder.equal(product.get("clockFace"), filterDto.getClockFace())));
        }
        if (filterDto.getGlass() != null) {
            predList.add(builder.and(builder.equal(product.get("glass"), filterDto.getGlass())));
        }
        if (filterDto.getGender() != null) {
            predList.add(builder.and(builder.equal(product.get("gender"), filterDto.getGender())));
        }
        if (filterDto.getWaterResistant() != null) {
            predList.add(builder.and(builder.equal(product.get("waterResistant"), filterDto.getWaterResistant())));
        }
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);
        query.where(predArray);

        // Ordering
        if (filterDto.getSorting().equals("lowPrice")) {
            query.orderBy(builder.asc(product.get("price")));
        } else if (filterDto.getSorting().equals("highPrice")) {
            query.orderBy(builder.desc(product.get("price")));
        } else if (filterDto.getSorting().equals("nameAsc")) {
            query.orderBy(builder.asc(product.get("name")));
        } else if (filterDto.getSorting().equals("nameDesc")) {
            query.orderBy(builder.desc(product.get("name")));
        } else {
            query.orderBy(builder.asc(product.get("price")));
        }

        try {
            List<Product> productList = super.find(query);
            return productList != null ? productList : null;
        } catch (NoResultException e) {
            return null;
        }
    }
}
