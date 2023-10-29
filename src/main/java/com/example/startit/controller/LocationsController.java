package com.example.startit.controller;

import com.example.startit.entity.LocationEntity;
import com.example.startit.service.LocationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@CrossOrigin
public class LocationsController {
    @Autowired
    private LocationsServices locationsServices;

    @GetMapping
    public ResponseEntity getLocation() {
        try {
            LocationEntity[] locations = locationsServices.getLocations();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка во время регистрации.");
        }
    }
}
