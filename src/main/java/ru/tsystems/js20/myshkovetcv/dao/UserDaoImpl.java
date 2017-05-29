package ru.tsystems.js20.myshkovetcv.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.User;

import javax.persistence.NoResultException;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public User findById(Long id) {
        logger.debug("Getting user by id: {}", id);
        return getByKey(id);
    }

    @Override
    public User findByEmail(String emailAddress) {
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.emailAddress LIKE :emailAddress")
                    .setParameter("emailAddress", emailAddress)
                    .getSingleResult();
            logger.debug("User found by email: {}", emailAddress);
            return user;
        } catch (NoResultException ex) {
            logger.warn("User not found by email: {}", emailAddress);
            return null;
        }
    }

    @Override
    public User findByUserName(String userName) {
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.userName LIKE :userName")
                    .setParameter("userName", userName)
                    .getSingleResult();
            logger.debug("User found by userName: {}", userName);
            return user;
        } catch (NoResultException ex) {
            logger.warn("User not found by userName: {}. Stack trace: {}", userName, ex.getMessage());
            return null;
        }
    }

    @Override
    public void save(User user) {
        persist(user);
        logger.debug("User saved: {}", user.getId());
    }

    @Override
    public void updateUser(User user) {
        update(user);
        logger.debug("User updated: {}", user.getId());
    }
}
