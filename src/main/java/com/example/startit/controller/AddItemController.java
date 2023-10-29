package com.example.startit.controller;

import com.example.startit.entity.ItemEntity;
import com.example.startit.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
