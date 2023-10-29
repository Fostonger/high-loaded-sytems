package com.example.startit.utils;

import com.example.startit.DTO.SearchFilter;
import com.example.startit.entity.ItemEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ItemSpecifications {

    public static Specification<ItemEntity> withFilter(SearchFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getItemName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), filter.getItemName() + "%"));
            }

            if (filter.getCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("category").get("id"), filter.getCategory()));
            }

            if (filter.getLocation() != null) {
                predicates.add(criteriaBuilder.equal(root.get("location").get("id"), filter.getLocation()));
            }

            if (filter.getSeller() != null) {
                predicates.add(criteriaBuilder.equal(root.get("seller").get("id"), filter.getSeller()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

