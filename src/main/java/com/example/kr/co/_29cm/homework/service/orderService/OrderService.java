package com.example.kr.co._29cm.homework.service.orderService;

import org.springframework.scheduling.annotation.Async;

public interface OrderService {
    @Async
    void orderItem() throws Exception;
}
