package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.Image;
import ua.com.ladyshoes.repository.ImageRepository;

import java.util.List;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> saveImage(List<Image> images) {
        return imageRepository.saveAll(images);
    }

}
