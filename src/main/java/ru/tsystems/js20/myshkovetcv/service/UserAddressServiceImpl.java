package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserAddress findById(Long id) {
        logger.debug("Trying to find user address: {}", id);
        return userAddressDao.findById(id);
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
        logger.debug("New user address saved");
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
            logger.debug("User address updated");
            return true;
        } else {
            logger.warn("User address not updated");
            return false;
        }
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
                    logger.debug("User address removed");
                } else {
                    logger.warn("User address not removed, because user address list not found");
                }
            } else {
                logger.warn("User address not removed, because user not found");
            }
        } else {
            logger.warn("User address not removed, because not valid ID");
        }
    }

    @Override
    public List<UserAddressDto> findAllAddressesCurrentUser() {
        List<UserAddress> userAddressList = userAddressDao.findUserAddresses(userService.getCurrentUser());
        List<UserAddressDto> userAddressDtoList = new ArrayList<>();
        for (UserAddress userAddress : userAddressList) {
            userAddressDtoList.add(new UserAddressDto(userAddress));
        }
        logger.debug("Getting list of addresses for current user");
        return userAddressDtoList;
    }

    @Override
    public ModelMap getUserAddressModel() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("userAddressDto", new UserAddressDto());
        logger.debug("New user address model formed");
        return modelMap;
    }

    @Override
    public ModelMap getUserAddressModelById(Long id) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(navBarService.getNavBarInfo());
        modelMap.addAttribute("userAddressDto", new UserAddressDto(findById(id)));
        logger.debug("User address model formed");
        return modelMap;
    }

    @Override
    public boolean currentUserHaveAccess(Long id) {
        User currentUser = userService.getCurrentUser();
        if (userService.hasRole("ROLE_ADMIN")) {
            return true;
        } else {
            User addressOwner = userAddressDao.findById(id).getUser();
            boolean haveAccess = currentUser.equals(addressOwner);
            logger.debug("User {} have access to address ID{}: {}", currentUser.getUserName(), id, haveAccess);
            return haveAccess;
        }
    }
}
