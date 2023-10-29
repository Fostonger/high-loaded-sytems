package com.example.startit.controller;

import com.example.startit.entity.ItemEntity;
import com.example.startit.service.ItemService;
import com.example.startit.DTO.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/add_item")
@CrossOrigin
public class AddItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/upload_photo")
    public ResponseEntity uploadImage(@RequestParam("image") MultipartFile photo,
                                      @RequestParam("seqNum") long seqNum,
                                      @RequestParam("item_id") Long item) {
        try {
            itemService.uploadImage(photo, seqNum, item);
            return ResponseEntity.ok(true);
        } catch (IOException e) {
            return ResponseEntity.ok(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время регистрации.");
        }
    }

    @PostMapping("/create_item")
    public ResponseEntity createItem(@RequestBody ItemEntity item) {
        try {
            ItemEntity createdItem = itemService.createItem(item);
            return ResponseEntity.ok(createdItem);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время входа в аккаунт.");
        }
    }

    @GetMapping("/fetch_item")
    public ResponseEntity fetchItem(
            @RequestParam(value = "item_name", required = false) String itemName,
            @RequestParam(value = "category", required = false) Long categoryId,
            @RequestParam(value = "location", required = false) Long locationId,
            @RequestParam(value = "seller", required = false) Long sellerId) {
        SearchFilter filter = new SearchFilter(itemName, categoryId, locationId, sellerId);
        try {
            ItemEntity[] createdItem = itemService.getItems(filter);
            return ResponseEntity.ok(createdItem);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время входа в аккаунт.");
        }
    }

    @GetMapping("/fetch_image_path")
    public ResponseEntity fetchImagePath(@RequestParam("item_id") String itemStr) {
        try {
            Long item = Long.parseLong(itemStr);
            String path = itemService.getImagePath(item);
            return ResponseEntity.ok(path);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время входа в аккаунт.");
        }
    }

    @GetMapping(value = "/fetch_image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] fetchImage(@RequestParam("image_path") String path) {
        try {
            return itemService.getImage(path);
        } catch (Exception e) {
            return new byte[0];
        }
    }

}
