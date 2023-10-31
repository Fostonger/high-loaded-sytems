package com.example.startit.repository;

import com.example.startit.entity.MessageEntity;
import com.example.startit.entity.StatusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByChat_Id(Long id);
}
