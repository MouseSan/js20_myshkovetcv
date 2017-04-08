package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(Long id);

}
