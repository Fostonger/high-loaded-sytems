package com.example.startit.repository;

import com.example.startit.entity.ItemEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
    List<ItemEntity> findAll(Specification<ItemEntity> spec);;
}
