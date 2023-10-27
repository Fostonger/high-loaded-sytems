package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private UserEntity user;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String encodedPassword;
}
