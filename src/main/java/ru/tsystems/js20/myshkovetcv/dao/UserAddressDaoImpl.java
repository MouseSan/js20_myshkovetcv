package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userAddressDao")
public class UserAddressDaoImpl extends AbstractDao<Long, UserAddress> implements UserAddressDao {

    @Override
    public UserAddress findById(Long id) {
        return getByKey(id);
    }

    @Override
    public UserAddress findByZipCode(Integer zipCode) {
        try {
            UserAddress userAddress = (UserAddress) getEntityManager()
                    .createQuery("SELECT u FROM UserAddress u WHERE u.zipCode = :zipCode")
                    .setParameter("zipCode", zipCode)
                    .getSingleResult();

            return userAddress;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(UserAddress userAddress) {
        persist(userAddress);
    }

    @Override
    public void updateUserAddress(UserAddress userAddress) {
        update(userAddress);
    }

    @Override
    public List<UserAddress> findAllUserAddresses() {
        List<UserAddress> userAddressList = getEntityManager()
                .createQuery("SELECT u FROM UserAddress u ORDER BY u.id ASC")
                .getResultList();
        return userAddressList;
    }

    public void deleteUserAddress(UserAddress userAddress) {
        delete(userAddress);
    }

    @Override
    public List<UserAddress> findUserAddresses(User user) {
        List<UserAddress> userAddressList = getEntityManager()
                .createQuery("SELECT u FROM UserAddress u WHERE u.user = :user")
                .setParameter("user", user)
                .getResultList();
        return userAddressList;
    }

}
