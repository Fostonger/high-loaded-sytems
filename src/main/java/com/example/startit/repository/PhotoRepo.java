package com.example.startit.repository;

import com.example.startit.entity.PhotoEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepo extends CrudRepository<PhotoEntity, Long> {
    PhotoEntity findByItem_Id(Long itemId);
}
