package com.kodlama.hrms.core.utilities.cloudinary.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    DataResult<?> saveImage(MultipartFile file);

}
