package com.example.startit.controller;

import com.example.startit.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
    @PostMapping("/register")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        return ResponseEntity.ok(true);
    }
}
