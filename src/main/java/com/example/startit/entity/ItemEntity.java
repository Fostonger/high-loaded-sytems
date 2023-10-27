package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="items")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;
}
