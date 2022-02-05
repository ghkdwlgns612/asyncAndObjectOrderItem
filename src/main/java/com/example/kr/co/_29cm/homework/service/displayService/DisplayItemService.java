package com.example.kr.co._29cm.homework.service.displayService;

import com.example.kr.co._29cm.homework.domain.Item;
import com.example.kr.co._29cm.homework.domain.dto.OrderItem;

import java.util.List;

public interface DisplayItemService {
    //주문 시 모든 아이템들을 출력하라.
    void displayAllItem(List<Item> items);
    //주문 완료 시 아이템 정보와 가격의 총합을 출력하라.
    void displayItemBills(List<OrderItem> items);
}
