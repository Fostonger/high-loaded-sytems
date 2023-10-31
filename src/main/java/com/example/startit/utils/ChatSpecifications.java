package com.example.startit.utils;

import com.example.startit.entity.ChatEntity;
import com.example.startit.entity.UserEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ChatSpecifications {

    public static Specification<ChatEntity> withUser(Long userId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("customer").get("id"), userId));
            predicates.add(criteriaBuilder.equal(root.get("item").get("seller").get("id"), userId));

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}