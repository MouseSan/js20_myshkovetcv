package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.UserAddressDao;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserAddressServiceTest {

    private List<UserAddress> userAddressList;
    private UserAddress userAddress1;
    private UserAddress userAddress2;
    private User user;

    @Mock
    private UserAddressDao userAddressDao;

    @InjectMocks
    private UserAddressService userAddressService = new UserAddressServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User(1L, "Dan", "White", new Date(System.currentTimeMillis()), "test@test.com", "danny", "123");

        userAddress1 = new UserAddress(1L, "USA", "NY", 112244, "7th Street 56", "47A", user);
        userAddress1 = new UserAddress(2L, "USA", "NY", 112241, "7th Street 58", "2B", user);

        userAddressList = new ArrayList<>();
        userAddressList.add(userAddress1);
        userAddressList.add(userAddress2);

        when(userAddressDao.findById(1L)).thenReturn(userAddress1);
        when(userAddressDao.findById(2L)).thenReturn(userAddress2);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        userAddressList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(userAddressDao);
    }

    @Test
    public void findByIdUserAddressTestTrue1() throws Exception {
        Assert.assertEquals(userAddress1, userAddressService.findById(1L));
    }

    @Test
    public void findByIdUserAddressTestTrue2() throws Exception {
        Assert.assertEquals(userAddress2, userAddressService.findById(2L));
    }

    @Test
    public void findByIdUserAddressTestFalse1() throws Exception {
        Assert.assertNotEquals(userAddress1, userAddressService.findById(2L));
    }

    @Test
    public void findByIdUserAddressTestFalse2() throws Exception {
        Assert.assertNotEquals(userAddress2, userAddressService.findById(1L));
    }

}
