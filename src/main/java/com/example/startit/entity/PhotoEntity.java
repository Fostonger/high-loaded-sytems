package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="photos")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;
    private Long seqNumber;
    @Column(nullable = false)
    private String photoPath;
}
