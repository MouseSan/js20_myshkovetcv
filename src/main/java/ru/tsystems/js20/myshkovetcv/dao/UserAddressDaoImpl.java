package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.List;

@Repository("userAddressDao")
public class UserAddressDaoImpl extends AbstractDao<Long, UserAddress> implements UserAddressDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserAddress findById(Long id) {
        logger.debug("Getting user address by id: {}", id);
        return getByKey(id);
    }

    @Override
    public void save(UserAddress userAddress) {
        persist(userAddress);
        logger.debug("User address saved: {}", userAddress.getId());
    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        update(userAddress);
        logger.debug("User address updated: {}", userAddress.getId());
    }

    @Override
    public List<UserAddress> findUserAddresses(User user) {
        List<UserAddress> userAddressList = getEntityManager()
                .createQuery("SELECT u FROM UserAddress u WHERE u.user = :user")
                .setParameter("user", user)
                .getResultList();
        logger.debug("Get list of addresses for user: {}", user.getUserName());
        return userAddressList;
    }
}
