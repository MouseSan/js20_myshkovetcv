package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.List;

public interface UserAddressService {

    UserAddress findById(Long id);

    UserAddress findByZipCode(Integer zipCode);

    void saveUserAddress(UserAddress userAddress);

    void updateUserAddress(UserAddress userAddress);

    List<UserAddress> findAllUserAddresses();

    void deleteUserAddress(UserAddress userAddress);

    List<UserAddress> findUserAddresses(User currentUser);
}
