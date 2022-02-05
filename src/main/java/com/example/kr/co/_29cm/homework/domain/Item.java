package com.example.kr.co._29cm.homework.domain;

import com.example.kr.co._29cm.homework.exception.type.SoldOutException;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Item {
    private Long itemId;
    private String itemName;
    private Long itemPrice;
    private Long itemStock;

    @Builder
    public Item(Long itemId, String itemName, Long itemPrice, Long itemStock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public boolean removeStock(Long quantity) {
        Long modStock = this.itemStock;
        try {
            modStock = this.itemStock - quantity;
            if (modStock < 0)
                throw new SoldOutException();
        } catch (SoldOutException e) {
            System.out.println("SoldOutException발생. 주문한 상품량이 재고량보다 큽니다.");
            return false;
        }
        this.itemStock = modStock;
        return true;
    }

    public void addStock(Long quantity) {
        this.itemStock += quantity;
    }
}
