package com.example.startit.DTO;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private Long statusId;
    private String name;
    private Double price;
    private String description;
    private Long locationId;
    private Long categoryId;
    private Long sellerId;
}

