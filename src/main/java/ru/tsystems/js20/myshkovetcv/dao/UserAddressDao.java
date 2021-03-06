package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.List;

public interface UserAddressDao {

    UserAddress findById(Long id);

    void save(UserAddress userAddress);

    void updateUserAddress(UserAddress userAddress);

    List<UserAddress> findUserAddresses(User user);
}
