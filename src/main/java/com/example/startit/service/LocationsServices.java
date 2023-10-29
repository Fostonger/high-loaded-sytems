package com.example.startit.service;

import com.example.startit.entity.CategoryEntity;
import com.example.startit.entity.LocationEntity;
import com.example.startit.repository.CategoriesRepo;
import com.example.startit.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationsServices {
    @Autowired
    private LocationRepo locationRepo;

    public LocationEntity[] getLocations() {
        List<LocationEntity> list = new ArrayList<>();
        locationRepo.findAll().forEach(list::add);
        return list.toArray(new LocationEntity[0]);
    }

}