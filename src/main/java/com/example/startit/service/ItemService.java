package com.example.startit.service;

import com.example.startit.entity.*;
import com.example.startit.exception.BadDataException;
import com.example.startit.repository.*;
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
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoriesRepo categoriesRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private StatusRepo statusRepo;
    @PersistenceContext
    private EntityManager entityManager;

    private static String UPLOAD_DIR = "uploads/";
    public PhotoEntity uploadImage(MultipartFile img, long imgSeqNumber, Long itemId) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + imgSeqNumber + img.getOriginalFilename());
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
}
