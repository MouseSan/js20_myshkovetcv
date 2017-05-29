package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.UserDao;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;
import ru.tsystems.js20.myshkovetcv.dto.enums.UserDtoValidationType;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.enums.UserRoles;

import java.util.Collection;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private NavBarService navBarService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public User findById(Long id) {
        logger.debug("Trying to find user: {}", id);
        return userDao.findById(id);
    }

    @Override
    public User getUserByUserName(String userName) {
        logger.debug("Getting user by userName: {}", userName);
        return userDao.findByUserName(userName);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.addUserRole(UserRoles.USER);
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDao.save(user);
        logger.debug("Saved new user: {}", user.getUserName());
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        User userToBeMerged = userDao.findById(userDto.getId());
        if (userToBeMerged != null) {
            userToBeMerged.setFirstName(userDto.getFirstName());
            userToBeMerged.setLastName(userDto.getLastName());
            userToBeMerged.setDateOfBirth(userDto.getDateOfBirth());
            userToBeMerged.setEmailAddress(userDto.getEmailAddress());
            userDao.updateUser(userToBeMerged);
            logger.debug("User updated: {}", userToBeMerged.getUserName());
            return true;
        } else {
            logger.warn("User {} not updated, because user ID {} not found", userDto.getUserName(), userDto.getId());
            return false;
        }
    }

    @Override
    public boolean updatePassword(UserDto userDto) {
        User userToBeMerged = userDao.findById(userDto.getId());
        if (userToBeMerged != null) {
            userToBeMerged.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userDao.updateUser(userToBeMerged);
            logger.debug("Password for user {} updated", userToBeMerged.getUserName());
            return true;
        } else {
            logger.warn("Password for user {} not updated, because user ID {} not found", userDto.getUserName(), userDto.getId());
            return false;
        }
    }

    @Override
    public boolean emailAddressNotUnique(String email) {
        User user = userDao.findByEmail(email);
        boolean unique = user != null;
        logger.debug("Email {} unique: {}", email, unique);
        return unique;
    }

    @Override
    public boolean userNameNotUnique(String userName) {
        User user = userDao.findByUserName(userName);
        boolean unique = user != null;
        logger.debug("UserName {} unique: {}", userName, unique);
        return unique;
    }

    @Override
    public User getCurrentUser() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        logger.debug("Getting current user: {}", userName);
        return userDao.findByUserName(userName);
    }

    @Override
    public UserDto getCurrentUserDto() {
        User user = getCurrentUser();
        logger.debug("Getting current userDto");
        return user != null ? new UserDto(user) : null;
    }

    @Override
    public ModelMap getUserSettingsWithAddressesModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("userDto", getCurrentUserDto());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());
        logger.debug("User settings with addresses model formed");
        return modelMap;
    }

    @Override
    public ModelMap getUserSettingsModel(UserDtoValidationType validationType) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        UserDto userDto = getCurrentUserDto();
        userDto.setUserDtoValidationType(validationType);
        modelMap.addAttribute("userDto", userDto);
        logger.debug("User settings model formed");
        return modelMap;
    }

    @Override
    public boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        logger.debug("Has role: {}", hasRole);
        return hasRole;
    }
}
