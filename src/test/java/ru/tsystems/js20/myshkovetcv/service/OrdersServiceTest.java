package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.OrdersDao;
import ru.tsystems.js20.myshkovetcv.dto.OrdersDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceTest {

    private List<Orders> ordersList;
    private List<Orders> ordersListCompleted;
    private Orders order1;
    private Orders order2;
    private OrdersState ordersStateCompleted;
    private User user;


    @Mock
    private OrdersDao ordersDao;

    @InjectMocks
    private OrdersService ordersService = new OrdersServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ordersStateCompleted = OrdersState.Completed;

        user = new User(1L, "Dan", "White", new Date(System.currentTimeMillis()), "test@test.com", "danny", "123");

        order1 = new Orders(1L, user, "Self", PaymentMethod.Cash, DeliveryMethod.ExpressDelivery, PaymentState.Pending, OrdersState.Completed, 2, 1800.0, new Date(System.currentTimeMillis()));
        order2 = new Orders(2L, user, "Self", PaymentMethod.Cash, DeliveryMethod.ExpressDelivery, PaymentState.Pending, OrdersState.Pending, 3, 1200.0, new Date(System.currentTimeMillis()));

        ordersList = new ArrayList<>();
        ordersList.add(order1);
        ordersList.add(order2);

        ordersListCompleted = new ArrayList<>();
        ordersList.add(order1);

        when(ordersDao.findById(1L)).thenReturn(order1);
        when(ordersDao.findById(2L)).thenReturn(order2);
        when(ordersDao.findAllOrders()).thenReturn(ordersList);
        when(ordersDao.findAllOrdersByState(OrdersState.Completed)).thenReturn(ordersListCompleted);
        when(ordersDao.findAllOrdersByUser(user)).thenReturn(ordersList);
        when(ordersDao.findAllOrdersByUserAndState(user, ordersStateCompleted)).thenReturn(ordersListCompleted);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        ordersList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(ordersDao);
    }

    @Test
    public void findByIdOrderTestTrue1() throws Exception {
        Assert.assertEquals(order1, ordersService.findById(1L));
    }

    @Test
    public void findByIdOrderTestTrue2() throws Exception {
        Assert.assertEquals(order2, ordersService.findById(2L));
    }

    @Test
    public void findByIdOrderTestFalse1() throws Exception {
        Assert.assertNotEquals(order2, ordersService.findById(1L));
    }

    @Test
    public void findByIdOrderTestFalse2() throws Exception {
        Assert.assertNotEquals(order1, ordersService.findById(2L));
    }

    @Test
    public void findAllOrdersDtoNotEmpty() throws Exception {
        List<OrdersDto> ordersDtoList = ordersService.findAllOrdersDto();
        Assert.assertTrue(ordersDtoList.size() > 0);
    }

}
