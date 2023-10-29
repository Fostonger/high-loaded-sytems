package com.example.startit.repository;

import com.example.startit.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
}
