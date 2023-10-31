package com.example.startit.repository;

import com.example.startit.entity.ChatEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepo extends CrudRepository<ChatEntity, Long> {
    List<ChatEntity> findAll(Specification<ChatEntity> spec);;
    Optional<ChatEntity> findByItem_IdAndCustomer_Id(Long itemId, Long customerId);
}
