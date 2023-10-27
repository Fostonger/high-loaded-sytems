package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="items")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String familyName;
    @Column(nullable = false)
    private Integer isuNumber;
}
