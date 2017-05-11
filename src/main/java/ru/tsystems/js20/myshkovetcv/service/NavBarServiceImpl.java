package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

@Service("navBarService")
@Transactional
public class NavBarServiceImpl implements NavBarService {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public ModelMap getCategoryListAndQuantityInCart() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("quantityInCart", shoppingCartService.getProductQuantityInCart());
        modelMap.addAttribute("categoryList", categoryService.getAllCategoriesDto());
        return modelMap;
    }
}
