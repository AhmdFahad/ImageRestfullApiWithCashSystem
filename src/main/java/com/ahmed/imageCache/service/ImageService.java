package com.ahmed.imageCache.service;

import com.ahmed.imageCache.model.Image;
import com.ahmed.imageCache.model.dao.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@Service
public class ImageService {
    ImageRepository imageRepository;
    //Todo:hannle  not found Exiption
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image){
        return  imageRepository.save(image);
    }
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
    public void updateImage(Image image, Long id) {
        Image uImage = imageRepository.findById(id).orElseThrow(() -> new ResourceAccessException("image not exists:"+id));
        uImage.setName(image.getName());
        uImage.setImageData(image.getImageData());
        imageRepository.save(image);
    }
}
