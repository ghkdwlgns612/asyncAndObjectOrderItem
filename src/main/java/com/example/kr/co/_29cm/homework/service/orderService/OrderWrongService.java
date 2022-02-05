package com.example.kr.co._29cm.homework.service.orderService;

import org.springframework.stereotype.Component;

@Component
public class OrderWrongService implements OrderService{
    @Override
    public void orderItem() {
        System.out.println("잘못된 명령입니다.");
    }
}
