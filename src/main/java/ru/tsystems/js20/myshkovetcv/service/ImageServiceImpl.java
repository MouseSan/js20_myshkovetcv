package ru.tsystems.js20.myshkovetcv.service;

import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.tsystems.js20.myshkovetcv.configuration.CloudinaryConfig;
import ru.tsystems.js20.myshkovetcv.dto.ProductDto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private CloudinaryConfig cloudinary;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public HashMap<String, String> updateImage(ProductDto productDto) {
        logger.debug("Start updating image for {}", productDto.getName());
        //Deleting from cloud previous image
        if (productDto.getImageId() != null && !productDto.getImageId().isEmpty()) {
            try {
                logger.debug("Trying to delete old image");
                Map destroyResult = cloudinary.getCloudinary().uploader().destroy(productDto.getImageId(),
                        ObjectUtils.emptyMap());
            } catch (IOException e) {
                logger.error("Unable to delete old image. StackTrace: {}", e.getMessage());
                e.printStackTrace();
            }
        }

        return createImage(productDto);
    }

    @Override
    public HashMap<String, String> createImage(ProductDto productDto) {
        logger.debug("Start creating new image");
        HashMap<String, String> imageProperty = new HashMap<>();
        imageProperty.put("url", "");
        imageProperty.put("public_id", "");

        MultipartFile file = productDto.getMultipartFile();
        if (file != null && !file.isEmpty()) {
            try {
                logger.debug("Trying to create new image");
                Map uploadResult = cloudinary.getCloudinary().uploader().upload(file.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                imageProperty.put("url", (String) uploadResult.get("url"));
                imageProperty.put("public_id", (String) uploadResult.get("public_id"));
                logger.debug("New image created successfully");
            } catch (IOException e) {
                logger.error("Unable to create new image. StackTrace: {}", e.getMessage());
                e.printStackTrace();
            }
        }
        return imageProperty;
    }
}
