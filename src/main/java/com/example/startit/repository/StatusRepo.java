package com.example.startit.repository;

import com.example.startit.entity.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo extends CrudRepository<StatusEntity, Long> {
}
