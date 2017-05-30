package ru.tsystems.js20.myshkovetcv;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.tsystems.js20.myshkovetcv.service.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CategoryServiceTest.class,
        BrandServiceTest.class,
        OrdersServiceTest.class,
        ProductServiceTest.class,
        SoldProductInfoServiceTest.class,
        UserAddressServiceTest.class,
        UserServiceTest.class,
})
public class ApplicationTests {
}
