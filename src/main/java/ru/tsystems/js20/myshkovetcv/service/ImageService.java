package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.dto.ProductDto;

import java.util.HashMap;

public interface ImageService {

    HashMap<String, String> updateImage(ProductDto productDto);

    HashMap<String, String> createImage(ProductDto productDto);

}
