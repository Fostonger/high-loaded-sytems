package com.example.startit.repository;

import com.example.startit.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepo extends CrudRepository<LocationEntity, Long> {
}
