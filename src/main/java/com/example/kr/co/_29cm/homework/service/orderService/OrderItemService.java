package com.example.kr.co._29cm.homework.service.orderService;

import com.example.kr.co._29cm.homework.domain.Item;
import com.example.kr.co._29cm.homework.domain.dto.OrderItemRequest;
import com.example.kr.co._29cm.homework.domain.dto.OrderItem;
import com.example.kr.co._29cm.homework.repository.ItemRepository;
import com.example.kr.co._29cm.homework.service.displayService.DisplayItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class OrderItemService implements OrderService{

    private final DisplayItemService displayItemService;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderItemService(DisplayItemService displayItemService, ItemRepository itemRepository) {
        this.displayItemService = displayItemService;
        this.itemRepository = itemRepository;
    }

    @Override
    public void orderItem() throws Exception {
        Scanner sc = new Scanner(System.in);
        List<OrderItem> result = new ArrayList<>();
        displayItemService.displayAllItem(itemRepository.findItems());

        while (true) {
            boolean flag = true;
            System.out.print("상품번호 : ");
            String itemId = sc.nextLine();
            System.out.print("수량 : ");
            String itemNumber = sc.nextLine();

            if (itemId.equals(" ") || itemNumber.equals(" ")) {
                for (int i=0;i<result.size();i++) {
                    if (!itemRepository.orderItem(result.get(i))) {
                        rollback(i,result);
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
                displayItemService.displayItemBills(result);
                break;
            } else {
                OrderItemRequest request = new OrderItemRequest(Long.valueOf(itemId), Long.valueOf(itemNumber));
                result.add(itemRepository.findByItemId(request));
            }
        }
    }

    private void rollback(int index, List<OrderItem> result) {
        for (int j = index-1; j >= 0; j--) {
            OrderItem item = result.get(j);
            Item findItem = itemRepository.findById(item.getItemId());
            findItem.addStock(item.getItemNumber());
        }
    }
}
