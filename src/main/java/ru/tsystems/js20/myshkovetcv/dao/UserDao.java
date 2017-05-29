package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.User;

public interface UserDao {

    User findById(Long id);

    User findByUserName(String userName);

    User findByEmail(String emailAddress);

    void save(User user);

    void updateUser(User user);
}
