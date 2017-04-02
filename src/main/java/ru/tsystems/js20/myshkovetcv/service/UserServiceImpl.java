package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.model.User;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByFirstName(String name) {
        return userDao.findByFirstName(name);
    }

    @Override
    public User findByLoginName(String name) {
        return userDao.findByLoginName(name);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToBeMerged = userDao.findById(user.getId());
        if (userToBeMerged != null) {
            userDao.updateUser(user);
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
