package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.service.BrandService;

@Component
public class BrandConverter implements Converter<Object, BrandDto> {

    @Autowired
    private BrandService brandService;

    @Override
    public BrandDto convert(Object o) {
        if (o instanceof BrandDto) {
            return (BrandDto) o;
        } else {
            Long id = Long.parseLong((String) o);
            BrandDto brandDto = brandService.findDtoById(id);
            return brandDto;
        }
    }
}
