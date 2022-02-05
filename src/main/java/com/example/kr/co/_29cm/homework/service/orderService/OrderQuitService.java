package com.example.kr.co._29cm.homework.service.orderService;

import org.springframework.stereotype.Component;

@Component
public class OrderQuitService implements OrderService{
    @Override
    public void orderItem() {
        System.out.println("고객님의 주문 감사합니다.");
        System.exit(0);
    }
}
