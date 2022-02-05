package com.example.kr.co._29cm.homework.domain.dto;

import lombok.Getter;

@Getter
public class OrderItemRequest {
    private Long itemId;
    private Long itemNumber;

    public OrderItemRequest(Long itemId, Long itemNumber) {
        this.itemId = itemId;
        this.itemNumber = itemNumber;
    }
}
