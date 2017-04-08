package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.UserProfile;
import ru.tsystems.js20.myshkovetcv.service.UserProfileService;

@Component
public class UserProfileIdToUserProfileClassConverter implements Converter<Object, UserProfile> {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfile convert(Object obj) {
        if (obj instanceof UserProfile) {
            return (UserProfile) obj;
        } else {
            Long id = Long.parseLong((String) obj);
            UserProfile userProfile = userProfileService.findById(id);
            return userProfile;
        }
    }

}
