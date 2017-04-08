package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.service.UserService;

@Component
public class UserIdToUserClassConverter implements Converter<Object, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(Object obj) {
        if (obj instanceof User) {
            return (User) obj;
        } else {
            Long id = Long.parseLong((String) obj);
            User user = userService.findById(id);
            return user;
        }
    }

}
