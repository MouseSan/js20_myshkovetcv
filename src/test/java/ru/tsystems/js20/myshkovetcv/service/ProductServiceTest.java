package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.ProductDao;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;
import ru.tsystems.js20.myshkovetcv.model.Category;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockFaceType;
import ru.tsystems.js20.myshkovetcv.model.enums.ClockGlassType;
import ru.tsystems.js20.myshkovetcv.model.enums.GenderType;
import ru.tsystems.js20.myshkovetcv.model.enums.WaterResistantType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private List<Product> productList;
    private Product product1;
    private Product product2;
    private Category categorySports;
    private Brand brandCasio;

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categorySports = new Category(1L, "Sports");
        brandCasio = new Brand(2L, "Casio");

        product1 = new Product(1L, "WR-100", 100.0, categorySports, 100.0,
                1.0, 10.0, brandCasio, true, ClockFaceType.Combined,
                ClockGlassType.Mineral, GenderType.Male, WaterResistantType.WR200,
                "Description", "Plug", "Plug");
        product2 = new Product(2L, "WR-200", 200.0, categorySports, 100.0,
                1.0, 10.0, brandCasio, true, ClockFaceType.Combined,
                ClockGlassType.Mineral, GenderType.Male, WaterResistantType.WR200,
                "Description", "Plug", "Plug");

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productDao.findByName("WR-100")).thenReturn(product1);
        when(productDao.findByName("WR-200")).thenReturn(product2);
        when(productDao.findById(1L)).thenReturn(product1);
        when(productDao.findById(2L)).thenReturn(product2);
        when(productDao.findAllProducts()).thenReturn(productList);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        productList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(productDao);
    }

    @Test
    public void findByNameProductTestTrue1() throws Exception {
        Assert.assertEquals(product1, productService.findByName("WR-100"));
    }

    @Test
    public void findByNameProductTestTrue2() throws Exception {
        Assert.assertEquals(product2, productService.findByName("WR-200"));
    }

    @Test
    public void findByNameProductTestFalse1() throws Exception {
        Assert.assertNotEquals(product2, productService.findByName("WR-100"));
    }

    @Test
    public void findByNameProductTestFalse2() throws Exception {
        Assert.assertNotEquals(product1, productService.findByName("WR-200"));
    }

    @Test
    public void findByIdProductTestTrue1() throws Exception {
        Assert.assertEquals(product1, productService.findById(1L));
    }

    @Test
    public void findByIdProductTestTrue2() throws Exception {
        Assert.assertEquals(product2, productService.findById(2L));
    }

    @Test
    public void findByIdProductTestFalse1() throws Exception {
        Assert.assertNotEquals(product1, productService.findById(2L));
    }

    @Test
    public void findByIdProductTestFalse2() throws Exception {
        Assert.assertNotEquals(product2, productService.findById(1L));
    }

    @Test
    public void getAllBrandsDtoTestNotEmpty() throws Exception {
        List<ProductDto> productDtoList = productService.getAllProductsDto();
        Assert.assertTrue(productDtoList.size() > 0);
    }

}
