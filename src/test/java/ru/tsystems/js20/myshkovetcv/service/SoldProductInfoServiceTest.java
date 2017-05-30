package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.SoldProductInfoDao;
import ru.tsystems.js20.myshkovetcv.model.*;
import ru.tsystems.js20.myshkovetcv.model.enums.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SoldProductInfoServiceTest {

    private List<SoldProductInfo> soldProductInfoList;
    private SoldProductInfo soldProductInfo1;
    private SoldProductInfo soldProductInfo2;
    private Product product;
    private Category categorySports;
    private Brand brandCasio;
    private User user;
    private Orders order;


    @Mock
    private SoldProductInfoDao soldProductInfoDao;

    @InjectMocks
    private SoldProductInfoService soldProductInfoService = new SoldProductInfoServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categorySports = new Category(1L, "Sports");
        brandCasio = new Brand(2L, "Casio");
        user = new User(1L, "Dan", "White", new Date(System.currentTimeMillis()), "test@test.com", "danny", "123");
        order = new Orders(1L, user, "Self", PaymentMethod.Cash, DeliveryMethod.ExpressDelivery, PaymentState.Pending, OrdersState.Completed, 2, 1800.0, new Date(System.currentTimeMillis()));
        product = new Product(1L, "WR-100", 100.0, categorySports, 100.0,
                1.0, 10.0, brandCasio, true, ClockFaceType.Combined,
                ClockGlassType.Mineral, GenderType.Male, WaterResistantType.WR200,
                "Description", "Plug", "Plug");

        soldProductInfo1 = new SoldProductInfo(1L, product, order, 2, 1500.0);
        soldProductInfo2 = new SoldProductInfo(2L, product, order, 3, 1500.0);

        soldProductInfoList = new ArrayList<>();
        soldProductInfoList.add(soldProductInfo1);
        soldProductInfoList.add(soldProductInfo2);

        when(soldProductInfoDao.getListByOrderId(order)).thenReturn(soldProductInfoList);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        soldProductInfoList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(soldProductInfoDao);
    }

    @Test
    public void getAllBrandsDtoTestNotEmpty() throws Exception {
        List<SoldProductInfo> list = soldProductInfoService.getListOfSoldProductsByOrderId(order);
        Assert.assertTrue(list.size() > 0);
    }
}
