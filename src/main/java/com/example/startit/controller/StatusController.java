package com.example.startit.controller;

import com.example.startit.entity.StatusEntity;
import com.example.startit.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statuses")
@CrossOrigin
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity registration() {
        try {
            StatusEntity[] locations = statusService.getSatuses();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время регистрации.");
        }
    }
}
