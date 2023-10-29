package com.example.startit.controller;

import com.example.startit.entity.CategoryEntity;
import com.example.startit.entity.UserEntity;
import com.example.startit.exception.BadRegistrationDataException;
import com.example.startit.service.CategoriesService;
import com.example.startit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity GetCategories() {
        try {
            CategoryEntity[] categories = categoriesService.getCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время регистрации.");
        }
    }
}
