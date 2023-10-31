package com.example.startit.service;

import com.example.startit.DTO.SearchFilter;
import com.example.startit.entity.*;
import com.example.startit.exception.BadDataException;
import com.example.startit.repository.*;
import com.example.startit.utils.ItemSpecifications;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ItemService {

    @Autowired
    private PhotoRepo photoRepo;
    @Autowired
    private ItemRepo itemRepo;
    @PersistenceContext
    private EntityManager entityManager;

    private static String UPLOAD_DIR = "uploads/";
    public PhotoEntity uploadImage(MultipartFile img, long imgSeqNumber, Long itemId) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + imgSeqNumber + itemId + img.getOriginalFilename());
        Files.createDirectories(path.getParent());
        Files.write(path, img.getBytes());

        PhotoEntity photo = new PhotoEntity();
        photo.setPhotoPath(path.toString());
        photo.setSeqNumber(imgSeqNumber);
        ItemEntity item = entityManager.getReference(ItemEntity.class, itemId);
        photo.setItem(item);

        return photoRepo.save(photo);
    }


    public ItemEntity createItem(ItemEntity item) throws BadDataException {
        if (item.isEmpty()) {
            throw new BadDataException("All nonnull properties must be set!");
        }
        StatusEntity status = entityManager.getReference(StatusEntity.class, item.getStatus().getId());
        item.setStatus(status);

        LocationEntity location = entityManager.getReference(LocationEntity.class, item.getLocation().getId());
        item.setLocation(location);

        CategoryEntity category = entityManager.getReference(CategoryEntity.class, item.getCategory().getId());
        item.setCategory(category);

        UserEntity seller = entityManager.getReference(UserEntity.class, item.getSeller().getId());
        item.setSeller(seller);

        return itemRepo.save(item);
    }

    public ItemEntity[] getItems(SearchFilter filter) throws BadDataException {
        return itemRepo.findAll(ItemSpecifications.withFilter(filter)).toArray( new ItemEntity[0]);
    }

    public String getImagePath(Long itemId) throws IOException {
        PhotoEntity photoData = photoRepo.findByItem_Id(itemId);
        return photoData.getPhotoPath();
    }

    public byte[] getImage(String path) throws IOException {
        Path imagePath = Paths.get(path);
        return Files.readAllBytes(imagePath);
    }
}
