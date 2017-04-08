package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.CategoryDao;
import ru.tsystems.js20.myshkovetcv.dao.ProductDao;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.sessionScope.SessionScope;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private SessionScope sessionScope;

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        product.setCategory(categoryDao.findById(product.getCategory().getId()));
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product productToBeMerged = productDao.findById(product.getId());
        if (productToBeMerged != null) {
            productDao.updateProduct(product);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    public void addProductToSeesionScope() {
        sessionScope.setProductList(findAllProducts());
    }
}
