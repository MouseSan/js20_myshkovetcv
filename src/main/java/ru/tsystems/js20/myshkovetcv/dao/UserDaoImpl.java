package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.User;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    @Override
    public User findById(Long id) {
        return getByKey(id);
    }

    @Override
    public User findByLoginName(String loginName) {
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.loginName LIKE :loginName")
                    .setParameter("loginName", loginName)
                    .getSingleResult();

            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public User findByFirstName(String firstName) {
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.firstName LIKE :firstName")
                    .setParameter("firstName", firstName)
                    .getSingleResult();

            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void updateUser(User user) {
        update(user);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> userList = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.id ASC")
                .getResultList();
        return userList;
    }

}