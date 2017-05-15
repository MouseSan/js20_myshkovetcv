package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.OrdersDao;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.dto.OrdersDto;
import ru.tsystems.js20.myshkovetcv.model.Orders;
import ru.tsystems.js20.myshkovetcv.model.Product;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.DeliveryMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.OrdersState;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentMethod;
import ru.tsystems.js20.myshkovetcv.model.enums.PaymentState;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private NavBarService navBarService;

    @Override
    public Orders findById(Long id) {
        return ordersDao.findById(id);
    }

    @Override
    public void saveOrdersReduceStock(Orders orders) {
//        if (orders.getPaymentMethod().equals(PaymentMethod.Card)) {
//            orders.setPaymentState(PaymentState.Paid);
//        } else {
//            orders.setPaymentState(PaymentState.Pending);
//        }
//        if (orders.getDeliveryMethod().equals(DeliveryMethod.Pickup)) {
//            orders.setDeliveryAddress("Self pickup");
//        }
//
//        Map<Product, Integer> productMap = shoppingCartService.getProductMap();
//        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
//            int quantityOfProduct = 0;
//            Product product = entry.getKey();
//            for (int i = 0; i < entry.getValue(); i++) {
//                quantityOfProduct++;
//                orders.addProductToList(productService.findById(product.getId()));
//            }
//            product.setStock(product.getStock() - quantityOfProduct);
////            productService.updateProduct(product);
//        }
//        User user = userService.getCurrentUser();
//        orders.setUser(user);
//        orders.setOrdersState(OrdersState.WaitingForShipment);
//        orders.setTotalPrice(shoppingCartService.getProductTotalPrice());
//        orders.setTotalQuantity(shoppingCartService.getProductQuantityInCart());
//        orders.setUser(userDao.findById(orders.getUser().getId()));
//        orders.setDateOfOrder(new Date());
//
//        shoppingCartService.removeAllProductFromCart();

        ordersDao.save(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
        Orders entity = ordersDao.findById(orders.getId());
        if (entity != null) {
            ordersDao.updateOrders(orders);
        }
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
    }

    @Override
    public List<Orders> findAllOrdersByUser(User user) {
        return ordersDao.findAllOrdersByUser(user);
    }

    @Override
    public List<Orders> findAllOrdersByUserAndState(User user, OrdersState ordersState) {
        return ordersDao.findAllOrdersByUserAndState(user, ordersState);
    }

    @Override
    public Map<Product, Integer> getProductMap(Orders orders) {
        Orders tempOrders = ordersDao.findById(orders.getId());
        Map<Product, Integer> productMap = new HashMap<>();
        List<Product> productList = tempOrders.getProductList();
        for (Product product : productList) {
            if (productMap.containsKey(product)) {
                Integer productQuantity = productMap.get(product);
                productMap.put(product, ++productQuantity);
            } else {
                productMap.put(product, 1);
            }
        }
        return productMap;
    }

    @Override
    public Orders copyOrder(Long id) {

        Orders originalOrder = ordersDao.findById(id);
        Orders copiedOrder = new Orders();
        copiedOrder.setUser(originalOrder.getUser());
        copiedOrder.setDateOfOrder(new Date());
        copiedOrder.setDeliveryAddress(originalOrder.getDeliveryAddress());
        copiedOrder.setPaymentMethod(originalOrder.getPaymentMethod());
        copiedOrder.setDeliveryMethod(originalOrder.getDeliveryMethod());

        if (copiedOrder.getPaymentMethod().equals(PaymentMethod.Card)) {
            copiedOrder.setPaymentState(PaymentState.Paid);
        } else {
            copiedOrder.setPaymentState(PaymentState.Pending);
        }
        if (copiedOrder.getDeliveryMethod().equals(DeliveryMethod.Pickup)) {
            copiedOrder.setDeliveryAddress("Self pickup");
        } else {
            copiedOrder.setDeliveryAddress(originalOrder.getDeliveryAddress());
        }

        double totalPrice = 0;
        for (Product product : originalOrder.getProductList()) {
            copiedOrder.addProductToList(productService.findById(product.getId()));
            totalPrice += productService.findById(product.getId()).getPrice();
        }
        copiedOrder.setTotalPrice(totalPrice);
        copiedOrder.setTotalQuantity(originalOrder.getProductList().size());

//        orders.setUser(userDao.findById(orders.getUser().getId()));
        ordersDao.save(copiedOrder);
        ordersDao.findById(copiedOrder.getId());
        return copiedOrder;
    }

    @Override
    public boolean checkAvailableToRepeat(Orders orders) {
        boolean allProductsAvailable = true;
        Map<Product, Integer> productMap = getProductMap(orders);
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = productService.findById(entry.getKey().getId());
            if (product.getStock() < entry.getValue()) {
                allProductsAvailable = false;
            }
        }
        return allProductsAvailable;
    }

    @Override
    public void saveCopiedOrdersReduceStock(Orders orders) {

        if (orders.getPaymentMethod().equals(PaymentMethod.Card)) {
            orders.setPaymentState(PaymentState.Paid);
        } else {
            orders.setPaymentState(PaymentState.Pending);
        }
        if (orders.getDeliveryMethod().equals(DeliveryMethod.Pickup)) {
            orders.setDeliveryAddress("Self pickup");
        }

        Map<Product, Integer> productMap = getProductMap(orders);
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            int quantityOfProduct = 0;
            Product product = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                quantityOfProduct++;
                orders.addProductToList(productService.findById(product.getId()));
            }
            product.setStock(product.getStock() - quantityOfProduct);
//            productService.updateProduct(product);
        }

        User user = userService.getCurrentUser();
        orders.setUser(user);
        orders.setOrdersState(OrdersState.WaitingForShipment);
        orders.setTotalPrice(orders.getTotalPrice());
        orders.setTotalQuantity(orders.getTotalQuantity());
        orders.setUser(userDao.findById(orders.getUser().getId()));
        orders.setDateOfOrder(new Date());

        ordersDao.save(orders);
    }

    @Override
    public ModelMap getOrdersModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("ordersDto", new OrdersDto());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());

        return modelMap;
    }
}
