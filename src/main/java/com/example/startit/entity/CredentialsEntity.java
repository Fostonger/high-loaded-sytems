package com.example.startit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="credentials")
public class CredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public UserEntity getUser() {
        UserEntity user = new UserEntity();
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}
