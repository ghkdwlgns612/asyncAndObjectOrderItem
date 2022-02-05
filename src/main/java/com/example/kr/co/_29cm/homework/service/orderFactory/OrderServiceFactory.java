package com.example.kr.co._29cm.homework.service.orderFactory;

import com.example.kr.co._29cm.homework.service.orderService.OrderService;

public interface OrderServiceFactory {
    OrderService getOrderService(String command);
}
