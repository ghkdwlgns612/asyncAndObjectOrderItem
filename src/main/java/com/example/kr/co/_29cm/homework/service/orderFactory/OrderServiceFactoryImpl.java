package com.example.kr.co._29cm.homework.service.orderFactory;

import com.example.kr.co._29cm.homework.repository.ItemRepository;
import com.example.kr.co._29cm.homework.service.displayService.DisplayItemService;
import com.example.kr.co._29cm.homework.service.orderService.OrderItemService;
import com.example.kr.co._29cm.homework.service.orderService.OrderQuitService;
import com.example.kr.co._29cm.homework.service.orderService.OrderService;
import com.example.kr.co._29cm.homework.service.orderService.OrderWrongService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFactoryImpl implements OrderServiceFactory{

    private final DisplayItemService displayItemService;
    private final ItemRepository itemRepository;

    public OrderServiceFactoryImpl(DisplayItemService displayItemService, ItemRepository itemRepository) {
        this.displayItemService = displayItemService;
        this.itemRepository = itemRepository;
    }

    @Override
    public OrderService getOrderService(String command) {
        if (command.equals("o"))
            return new OrderItemService(displayItemService,itemRepository);
        else if (command.equals("q") || command.equals("quit"))
            return new OrderQuitService();
        else
            return new OrderWrongService();
    }
}
