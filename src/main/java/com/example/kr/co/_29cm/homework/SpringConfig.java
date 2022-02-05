package com.example.kr.co._29cm.homework;

import com.example.kr.co._29cm.homework.repository.InMemoryItemRepository;
import com.example.kr.co._29cm.homework.repository.ItemRepository;
import com.example.kr.co._29cm.homework.service.displayService.DisplayItemService;
import com.example.kr.co._29cm.homework.service.displayService.DisplayItemServiceImpl;
import com.example.kr.co._29cm.homework.service.orderFactory.OrderServiceFactory;
import com.example.kr.co._29cm.homework.service.orderFactory.OrderServiceFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfig {

    private final ItemRepository itemRepository;
    private final DisplayItemService displayItemService;

    public SpringConfig(ItemRepository itemRepository, DisplayItemService displayItemService) {
        this.itemRepository = itemRepository;
        this.displayItemService = displayItemService;
    }

    @Bean
    @Primary
    public ItemRepository itemRepository() {
        return new InMemoryItemRepository();
    }

    @Bean
    @Primary
    public DisplayItemService displayItem() {
        return new DisplayItemServiceImpl();
    }

    @Bean
    public OrderServiceFactory orderServiceFactory() {
        return new OrderServiceFactoryImpl(displayItemService,itemRepository);
    }
}
