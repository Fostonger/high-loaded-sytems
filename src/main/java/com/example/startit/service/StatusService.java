package com.example.startit.service;

import com.example.startit.entity.CategoryEntity;
import com.example.startit.entity.StatusEntity;
import com.example.startit.repository.PhotoRepo;
import com.example.startit.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepo;

    public StatusEntity[] getSatuses() {
        List<StatusEntity> list = new ArrayList<>();
        statusRepo.findAll().forEach(list::add);
        return list.toArray(new StatusEntity[0]);
    }
}
