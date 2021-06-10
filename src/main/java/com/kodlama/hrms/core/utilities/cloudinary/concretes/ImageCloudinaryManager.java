package com.kodlama.hrms.core.utilities.cloudinary.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kodlama.hrms.core.utilities.cloudinary.abstracts.ImageService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.ErrorResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageCloudinaryManager implements ImageService {

    private final Cloudinary cloudinary;

    @Autowired
    public ImageCloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<?> saveImage(MultipartFile file) {
        try {
            return new SuccessDataResult<>(this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<>();
    }
}
