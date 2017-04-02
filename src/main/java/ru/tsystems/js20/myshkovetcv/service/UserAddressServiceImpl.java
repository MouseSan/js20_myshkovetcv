package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.UserAddressDao;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.List;

@Service("userAddressService")
@Transactional
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao userAddressDao;

    @Autowired
    private UserDao userDao;

    @Override
    public UserAddress findById(Long id) {
        return userAddressDao.findById(id);
    }

    @Override
    public UserAddress findByZipCode(Integer zipCode) {
        return userAddressDao.findByZipCode(zipCode);
    }

    @Override
    public void saveUserAddress(UserAddress userAddress) {
        userAddress.setUser(userDao.findById(userAddress.getUser().getId()));
        userAddressDao.save(userAddress);
    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        UserAddress userAddressToBeMerged = userAddressDao.findById(userAddress.getId());
        if (userAddressToBeMerged != null) {
            userAddressDao.updateUserAddress(userAddress);
        }
    }

    @Override
    public List<UserAddress> findAllUserAddresses() {
        return userAddressDao.findAllUserAddresses();
    }
}
