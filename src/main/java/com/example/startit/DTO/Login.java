package com.example.startit.DTO;

import lombok.Data;

@Data
public class Login {
    private Long userId;
    private String login;
    private String encodedPassword;
}
