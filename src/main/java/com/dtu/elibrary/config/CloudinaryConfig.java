package com.dtu.elibrary.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary getCloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dbo5fc7j0");
        config.put("api_key", "728288251517665");
        config.put("api_secret", "V23hOpLyo3gGUvhkN9OLqzUuHOA");
        config.put("secure", "true");
        return new Cloudinary(config);
    }

}
