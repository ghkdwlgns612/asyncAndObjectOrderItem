package com.example.kr.co._29cm.homework.domain.dto;

import lombok.Getter;

@Getter
public class OrderItem {
    private Long itemId;
    private String itemName;
    private Long itemPrice;
    private Long itemStock;
    private Long itemNumber;

    public OrderItem(Long itemId, String itemName, Long itemPrice, Long itemStock, Long itemNumber) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemNumber = itemNumber;
    }
}
