package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.UserAddressDto;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.List;

public interface UserAddressService {

    UserAddress findById(Long id);

    UserAddress findByZipCode(Integer zipCode);

    void saveUserAddress(UserAddressDto userAddressDto);

    boolean updateUserAddress(UserAddressDto userAddressDto);

    List<UserAddress> findAllUserAddresses();

    void deleteUserAddress(Long id);

    List<UserAddressDto> findUserAddressDto(User currentUser);

    List<UserAddressDto> findAllAddressesCurrentUser();

    ModelMap getUserAddressModel();

    ModelMap getUserAddressModelById(Long id);

    boolean currentUserHaveAccess(Long id);
}
