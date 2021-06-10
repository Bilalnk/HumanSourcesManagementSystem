package com.kodlama.hrms.CloudinaryConfig;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kodlama.hrms.core.utilities.cloudinary.abstracts.ImageService;
import com.kodlama.hrms.core.utilities.cloudinary.concretes.ImageCloudinaryManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "bilalnk",
                "api_key", "153197481419314",
                "api_secret", "-FFDYPMXvrzv33Y6a39_xM--Org"
        ));
    }

    @Bean
    public ImageService imageService(){
        return new ImageCloudinaryManager(cloudinary());
    }

}
