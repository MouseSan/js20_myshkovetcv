package ru.tsystems.js20.myshkovetcv.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.service.BrandService;

@Component
public class BrandConverter implements Converter<Object, BrandDto> {

    @Autowired
    private BrandService brandService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public BrandDto convert(Object o) {
        if (o instanceof BrandDto) {
            logger.debug("BrandDto no need in conversion");
            return (BrandDto) o;
        } else {
            Long id = Long.parseLong((String) o);
            logger.debug("BrandDto converted from ID: {}", id);
            return brandService.findDtoById(id);
        }
    }
}
