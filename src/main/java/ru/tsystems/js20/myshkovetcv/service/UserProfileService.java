package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(Long id);

}
