package com.example.startit.DTO;

import lombok.Data;

@Data
public class Photo {
    private Long id;
    private Long itemId;
    private Long imageSeqNumber;
    private String imagePath;
}
