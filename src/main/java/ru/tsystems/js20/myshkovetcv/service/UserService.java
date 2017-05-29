package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.model.User;

public interface UserService {

    User findById(Long id);

    User getUserByUserName(String userName);

    void saveUser(UserDto userDto);

    boolean updateUser(UserDto userDto);

    boolean updatePassword(UserDto userDto);

    boolean emailAddressNotUnique(String email);

    boolean userNameNotUnique(String userName);

    UserDto getCurrentUserDto();

    User getCurrentUser();

    ModelMap getUserSettingsWithAddressesModel();

    ModelMap getUserSettingsModel(UserDtoValidationType validationType);

    boolean hasRole(String role);
}
