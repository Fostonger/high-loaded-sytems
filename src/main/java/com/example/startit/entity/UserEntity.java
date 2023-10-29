package com.example.startit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "family_name",nullable = false)
    private String familyName;
    @Column(name = "isu_number",nullable = false)
    private Integer isuNumber;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;

    @JsonIgnore
    public boolean isEmpty() {
        return id == null || name == null || familyName == null
                || isuNumber == null || username == null || password == null;
    }
}
