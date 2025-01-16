package com.ambrose.ambroseshop.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ambrose.ambroseshop.dto.ImageDto;
import com.ambrose.ambroseshop.model.Image;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}

