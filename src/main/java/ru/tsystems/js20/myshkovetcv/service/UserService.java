package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByFirstName(String name);

    User findByLoginName(String name);

    void saveUser(User user);

    void updateUser(User user);

    List<User> findAllUsers();

}
