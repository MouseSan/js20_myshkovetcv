package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.UserProfileDao;
import ru.tsystems.js20.myshkovetcv.model.UserProfile;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public List<UserProfile> findAll() {
        return userProfileDao.findAll();
    }

    @Override
    public UserProfile findByType(String type) {
        return userProfileDao.findByType(type);
    }

    @Override
    public UserProfile findById(Long id) {
        return userProfileDao.findById(id);
    }
}
