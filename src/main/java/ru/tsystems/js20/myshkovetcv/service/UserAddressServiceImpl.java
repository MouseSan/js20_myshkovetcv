package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dao.UserAddressDao;
import ru.tsystems.js20.myshkovetcv.dto.UserAddressDto;
import ru.tsystems.js20.myshkovetcv.model.User;
import ru.tsystems.js20.myshkovetcv.model.UserAddress;

import java.util.ArrayList;
import java.util.List;

@Service("userAddressService")
@Transactional
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressDao userAddressDao;
    @Autowired
    private UserService userService;
    @Autowired
    private NavBarService navBarService;

    @Override
    public UserAddress findById(Long id) {
        return userAddressDao.findById(id);
    }

    @Override
    public UserAddress findByZipCode(Integer zipCode) {
        return userAddressDao.findByZipCode(zipCode);
    }

    @Override
    public void saveUserAddress(UserAddressDto userAddressDto) {
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry(userAddressDto.getCountry());
        userAddress.setCity(userAddressDto.getCity());
        userAddress.setStreet(userAddressDto.getStreet());
        userAddress.setZipCode(userAddressDto.getZipCode());
        userAddress.setApartmentNumber(userAddressDto.getApartmentNumber());
        userAddress.setUser(userService.getCurrentUser());
        userAddressDao.save(userAddress);
    }

    @Override
    public boolean updateUserAddress(UserAddressDto userAddressDto) {
        UserAddress userAddressToBeMerged = userAddressDao.findById(userAddressDto.getId());
        if (userAddressToBeMerged != null) {
            userAddressToBeMerged.setCountry(userAddressDto.getCountry());
            userAddressToBeMerged.setCity(userAddressDto.getCity());
            userAddressToBeMerged.setStreet(userAddressDto.getStreet());
            userAddressToBeMerged.setZipCode(userAddressDto.getZipCode());
            userAddressToBeMerged.setApartmentNumber(userAddressDto.getApartmentNumber());
            userAddressDao.updateUserAddress(userAddressToBeMerged);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<UserAddress> findAllUserAddresses() {
        return userAddressDao.findAllUserAddresses();
    }

    @Override
    public void deleteUserAddress(Long id) {
        UserAddress userAddress = userAddressDao.findById(id);
        if (userAddress != null) {
            User user = userAddress.getUser();
            if (user != null) {
                List<UserAddress> userAddressList = user.getUserAddressList();
                if (userAddressList != null && userAddressList.contains(userAddress)) {
                    userAddressList.remove(userAddress);
                }
            }

        }
    }

    @Override
    public List<UserAddressDto> findUserAddressDto(User user) {
        List<UserAddress> userAddressList = userAddressDao.findUserAddresses(user);
        List<UserAddressDto> userAddressDto = new ArrayList<>();
        for (UserAddress userAddress : userAddressList) {
            userAddressDto.add(new UserAddressDto(userAddress));
        }
        return userAddressDto;
    }

    @Override
    public List<UserAddressDto> findAllAddressesCurrentUser() {
        return findUserAddressDto(userService.getCurrentUser());
    }

    @Override
    public ModelMap getUserAddressModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("userAddressDto", new UserAddressDto());
        return modelMap;
    }

    @Override
    public ModelMap getUserAddressModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getCategoryListAndQuantityInCart());
        modelMap.addAttribute("userAddressDto", new UserAddressDto(findById(id)));
        return modelMap;
    }

    @Override
    public boolean currentUserHaveAccess(Long id) {
        User currentUser = userService.getCurrentUser();
        if (userService.hasRole("ROLE_ADMIN")) {
            return true;
        } else {
            User addressOwner = userAddressDao.findById(id).getUser();
            return currentUser.equals(addressOwner);
        }
    }
}
