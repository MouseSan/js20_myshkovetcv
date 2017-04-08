package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;
import ru.tsystems.js20.myshkovetcv.service.UserAddressService;

@Component
public class UserAddressIdToUserAddressClassConverter implements Converter<Object, UserAddress> {

    @Autowired
    private UserAddressService userAddressService;

    @Override
    public UserAddress convert(Object obj) {
        if (obj instanceof UserAddress) {
            return (UserAddress) obj;
        } else {
            Long id = Long.parseLong((String) obj);
            UserAddress userAddress = userAddressService.findById(id);
            return userAddress;
        }
    }

}
