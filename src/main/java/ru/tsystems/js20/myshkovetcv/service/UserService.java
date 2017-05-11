package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByFirstName(String name);

    User getUserByEmail(String emailAddress);

    User getUserByUserName(String userName);

    UserDto getUserDtoByEmail(String emailAddress);

    void saveUser(UserDto userDto);

    boolean updateUser(UserDto userDto);

    boolean updatePassword(UserDto userDto);

    List<User> findAllUsers();

    boolean emailAddressNotUnique(String email);

    boolean userNameNotUnique(String userName);

    String getPrincipal();

    UserDto getCurrentUserDto();

    User getCurrentUser();

    ModelMap getUserSettingsWithAddressesModel();

    ModelMap getUserSettingsModel(UserDtoValidationType validationType);

    boolean hasRole(String role);
}
