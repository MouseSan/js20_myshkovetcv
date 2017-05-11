package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.User;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    User findByUserName(String userName);

    User findByEmail(String emailAddress);

    User findByFirstName(String name);

    void save(User user);

    void updateUser(User user);

    List<User> findAllUsers();

}
