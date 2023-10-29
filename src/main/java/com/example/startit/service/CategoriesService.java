package com.example.startit.service;

import com.example.startit.entity.CategoryEntity;
import com.example.startit.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepo categoriesRepo;

    public CategoryEntity[] getCategories() {
        List<CategoryEntity> list = new ArrayList<>();
        categoriesRepo.findAll().forEach(list::add);
        return list.toArray(new CategoryEntity[0]);
    }

}
