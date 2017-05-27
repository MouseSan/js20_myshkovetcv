package ru.tsystems.js20.myshkovetcv.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Map;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class CloudinaryConfig {

    @Autowired
    private Environment environment;

    private Cloudinary cloudinary;

    @PostConstruct
    private void init() {
        Map config = ObjectUtils.asMap(
                "cloud_name", environment.getRequiredProperty("cloudinary.cloud.name"),
                "api_key", environment.getRequiredProperty("cloudinary.api.key"),
                "api_secret", environment.getRequiredProperty("cloudinary.api.secret"));
        cloudinary = new Cloudinary(config);
    }

    public Cloudinary getCloudinary() {
        return cloudinary;
    }
}
