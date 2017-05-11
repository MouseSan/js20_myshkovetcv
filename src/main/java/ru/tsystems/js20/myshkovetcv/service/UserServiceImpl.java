package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private NavBarService navBarService;
    @Autowired
    private ShoppingCartService shoppingCartService;


    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByFirstName(String name) {
        return userDao.findByFirstName(name);
    }

    @Override
    public User getUserByEmail(String emailAddress) {
        return userDao.findByEmail(emailAddress);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public UserDto getUserDtoByEmail(String emailAddress) {
        User user = userDao.findByEmail(emailAddress);
        return new UserDto(user);
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
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updatePassword(UserDto userDto) {
        User userToBeMerged = userDao.findById(userDto.getId());
        if (userToBeMerged != null) {
            userToBeMerged.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userDao.updateUser(userToBeMerged);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public boolean emailAddressNotUnique(String email) {
        User user = userDao.findByEmail(email);
        return user != null;
    }

    @Override
    public boolean userNameNotUnique(String userName) {
        User user = userDao.findByUserName(userName);
        return user != null;
    }

    @Override
    public String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @Override
    public User getCurrentUser() {
        return userDao.findByUserName(getPrincipal());
    }

    @Override
    public UserDto getCurrentUserDto() {
        User user = getCurrentUser();
        return user != null ? new UserDto(user) : null;
    }

    @Override
    public ModelMap getUserSettingsWithAddressesModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("userDto", getCurrentUserDto());
        modelMap.addAttribute("addressList", userAddressService.findAllAddressesCurrentUser());
        return modelMap;
    }

    @Override
    public ModelMap getUserSettingsModel(UserDtoValidationType validationType) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        UserDto userDto = getCurrentUserDto();
        userDto.setUserDtoValidationType(validationType);
        modelMap.addAttribute("userDto", userDto);
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
        return hasRole;
    }
}
