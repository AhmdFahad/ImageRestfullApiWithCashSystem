package com.ahmed.imageCache.controller;

import com.ahmed.imageCache.model.Image;
import com.ahmed.imageCache.service.ImageService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/v1/api/")


public class ImageControoler {
    ImageService imageService;

    //Todo:Validate Data
    public ImageControoler(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value="image" )
    public Image saveImage(@RequestBody Image image){
        return  imageService.saveImage(image);
    }
    @DeleteMapping("image/{id}")
    public void deleteImage(@PathVariable(name = "id") Long id){
        imageService.deleteImage(id);
    }

    @PutMapping("image/{id}")
    public void updateImage(@RequestBody Image image, @PathVariable(name = "id")Long id){
        imageService.updateImage(image,id);
    }

    @GetMapping(value = "images")
    public List<Image> getAllImage(){
        return  imageService.getAllImage();
    }

    @GetMapping(value = "image/{id}")
    public Image getImage(@PathVariable(name = "id")Long id){
        return  imageService.getImage(id);
    }

}
