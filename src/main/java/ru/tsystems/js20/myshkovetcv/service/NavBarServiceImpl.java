package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import ru.tsystems.js20.myshkovetcv.dto.UserDto;

@Service("navBarService")
@Transactional
public class NavBarServiceImpl implements NavBarService {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelMap getNavBarInfo() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        modelMap.addAttribute("categoryList", categoryService.getAllCategoriesDto());

        UserDto userDto = userService.getCurrentUserDto();
        if (userDto != null) {
            modelMap.addAttribute("currentUserName", userDto.getFirstName());
        } else {
            modelMap.addAttribute("currentUserName", "");
        }

        logger.debug("Navigation bar model formed");
        return modelMap;
    }
}
