package com.example.startit.DTO;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String familyName;
    private Integer isuNumber;
    private String username;
    private String encodedPassword;
}
