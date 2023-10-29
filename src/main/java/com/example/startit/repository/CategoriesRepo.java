package com.example.startit.repository;

import com.example.startit.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepo extends CrudRepository<CategoryEntity, Long> {
}
