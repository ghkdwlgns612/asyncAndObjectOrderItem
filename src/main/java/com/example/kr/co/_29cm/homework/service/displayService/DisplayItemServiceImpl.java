package com.example.kr.co._29cm.homework.service.displayService;

import com.example.kr.co._29cm.homework.domain.Item;
import com.example.kr.co._29cm.homework.domain.dto.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisplayItemServiceImpl implements DisplayItemService {

    @Override
    public void displayAllItem(List<Item> items) {
        System.out.println("상품번호   상품명                                        판매가격    재고수");
        for (Item item : items) {
            System.out.println(item.getItemId() + "    " +
                    item.getItemName() + "                " +
                    item.getItemPrice() + "      " +
                    item.getItemStock());
        }
        System.out.println("");
    }

    @Override
    public void displayItemBills(List<OrderItem> items) {
        Long sumPrice = 0L;
        System.out.println("주문내역:");
        System.out.println("----------------------------------------");
        for (OrderItem item : items) {
            sumPrice += item.getItemPrice() * item.getItemNumber();
            System.out.println(item.getItemName() + " - " + item.getItemNumber() + "개");
        }
        System.out.println("----------------------------------------");
        System.out.println("주문금액: " + sumPrice + "원");
        if (sumPrice < 50000L) {
            System.out.println("배송비: " + "2,500원");
            sumPrice += 2500L;
        }
        System.out.println("----------------------------------------");
        System.out.println("지불금액: " + sumPrice + "원");
        System.out.println("----------------------------------------");
    }
}
