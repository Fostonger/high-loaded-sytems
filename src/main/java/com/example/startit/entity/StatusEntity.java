package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String description;
}
