package com.example.startit.controller;

import com.example.startit.entity.UserEntity;
import com.example.startit.exception.BadRegistrationDataException;
import com.example.startit.exception.PasswordIncorrectException;
import com.example.startit.exception.UserDoesNotExistException;
import com.example.startit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok(true);
        } catch (BadRegistrationDataException e) {
            return ResponseEntity.ok(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время регистрации.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            userService.login(user);
            return ResponseEntity.ok(true);
        } catch (PasswordIncorrectException | UserDoesNotExistException e) {
            return ResponseEntity.ok("Введён неверный логин или пароль");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время входа в аккаунт.");
        }
    }
}
