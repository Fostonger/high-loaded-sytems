package com.example.startit.service;

import com.example.startit.entity.CategoryEntity;
import com.example.startit.entity.LocationEntity;
import com.example.startit.entity.StatusEntity;
import com.example.startit.entity.UserEntity;
import com.example.startit.exception.BadRegistrationDataException;
import com.example.startit.exception.PasswordIncorrectException;
import com.example.startit.exception.UserDoesNotExistException;
import com.example.startit.repository.CategoriesRepo;
import com.example.startit.repository.LocationRepo;
import com.example.startit.repository.StatusRepo;
import com.example.startit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StatusRepo catRepository;


    public UserEntity registration(UserEntity user) throws BadRegistrationDataException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new BadRegistrationDataException("Пользователь с таким именем уже существует");
        } else if (user.getUsername().length() < 3) {
            throw new BadRegistrationDataException("Имя пользоватлея должно быть не менее 3-х символов");
        } else if (user.getPassword().length() < 3) {
            throw new BadRegistrationDataException("Пароль должен быть не меньше 3-х символов");
        }
        user.setPassword(getSHA256Hash(user.getPassword()));
        return userRepo.save(user);
    }

    public UserEntity login(UserEntity user) throws UserDoesNotExistException, PasswordIncorrectException {
        UserEntity u = userRepo.findByUsername(user.getUsername());
        if (u == null) {
            throw new UserDoesNotExistException("Не найден пользователь с таким именем.");
        }
        if (!u.getPassword().equals(getSHA256Hash(user.getPassword()))) {
            throw new PasswordIncorrectException("Неверный пароль.");
        }
        return u;
    }

    // TODO: sha hashing
    private String getSHA256Hash(String input) { return input; }
}
