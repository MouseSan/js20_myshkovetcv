package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.dto.ProductDto;

import java.util.List;

public interface WebService {

    List<ProductDto> getProducts();

}
