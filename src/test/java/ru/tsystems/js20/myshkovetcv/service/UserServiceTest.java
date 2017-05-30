package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private List<User> userList;
    private User user1;
    private User user2;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user1 = new User(1L, "Dan", "White", new Date(System.currentTimeMillis()), "test1@test.com", "danny", "123");
        user2 = new User(2L, "Mick", "White", new Date(System.currentTimeMillis()), "test2@test.com", "mikey", "123");

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        when(userDao.findById(1L)).thenReturn(user1);
        when(userDao.findById(2L)).thenReturn(user2);
        when(userDao.findByUserName("danny")).thenReturn(user1);
        when(userDao.findByUserName("mikey")).thenReturn(user2);
        when(userDao.findByEmail("test1@test.com")).thenReturn(user1);
        when(userDao.findByEmail("test2@test.com")).thenReturn(user2);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        userList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(userDao);
    }

    @Test
    public void findByIdUserTestTrue1() throws Exception {
        Assert.assertEquals(user1, userService.findById(1L));
    }

    @Test
    public void findByIdUserTestTrue2() throws Exception {
        Assert.assertEquals(user2, userService.findById(2L));
    }

    @Test
    public void findByIdUserTestFalse1() throws Exception {
        Assert.assertNotEquals(user1, userService.findById(2L));
    }

    @Test
    public void findByIdUserTestFalse2() throws Exception {
        Assert.assertNotEquals(user2, userService.findById(1L));
    }

    @Test
    public void findByNameUserTestTrue1() throws Exception {
        Assert.assertEquals(user1, userService.getUserByUserName("danny"));
    }

    @Test
    public void findByNameUserTestTrue2() throws Exception {
        Assert.assertEquals(user2, userService.getUserByUserName("mikey"));
    }

    @Test
    public void findByNameUserTestFalse1() throws Exception {
        Assert.assertNotEquals(user1, userService.getUserByUserName("mikey"));
    }

    @Test
    public void findByNameUserTestFalse2() throws Exception {
        Assert.assertNotEquals(user2, userService.getUserByUserName("danny"));
    }

    @Test
    public void userNameNotUniqueTrue() throws Exception {
        Assert.assertTrue(userService.userNameNotUnique("danny"));
    }

    @Test
    public void userNameNotUniqueFalse() throws Exception {
        Assert.assertFalse(userService.userNameNotUnique("fil"));
    }

    @Test
    public void emailAddressNotUniqueTrue() throws Exception {
        Assert.assertTrue(userService.emailAddressNotUnique("test1@test.com"));
    }

    @Test
    public void emailAddressNotUniqueFalse() throws Exception {
        Assert.assertFalse(userService.emailAddressNotUnique("test333@test.com"));
    }

}
