package com.example.startit.DTO;

import lombok.Data;

@Data
public class SearchFilter {
    String itemName;
    Long category;
    Long location;
    Long seller;

    public SearchFilter(String itemName, Long category, Long location, Long seller) {
        this.category = category;
        this.location = location;
        this.seller = seller;
        this.itemName = itemName;
    }
}
