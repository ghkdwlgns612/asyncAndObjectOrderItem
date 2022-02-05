package com.example.kr.co._29cm.homework.repository;

import com.example.kr.co._29cm.homework.domain.Item;
import com.example.kr.co._29cm.homework.domain.dto.OrderItemRequest;
import com.example.kr.co._29cm.homework.domain.dto.OrderItem;

import java.util.List;

public interface ItemRepository {
    void init();

    void clear();

    boolean orderItem(OrderItem response) throws Exception;

    OrderItem findByItemId(OrderItemRequest request);

    Item findById(Long itemId);

    List<Item> findItems();
}
