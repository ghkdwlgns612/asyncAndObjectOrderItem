package com.example.kr.co._29cm.homework.repository;

import com.example.kr.co._29cm.homework.domain.Item;
import com.example.kr.co._29cm.homework.domain.dto.OrderItemRequest;
import com.example.kr.co._29cm.homework.domain.dto.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryItemRepository implements ItemRepository {

    private static final Map<Long, Item> items = new HashMap<>();

    @Override
    public void init() {
        items.put(768848L, Item.builder().itemId(768848L).itemName("[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종").itemPrice(21000L).itemStock(45L).build());
        items.put(748943L, Item.builder().itemId(748943L).itemName("디오디너리 데일리 세트 (Daily set)").itemPrice(19000L).itemStock(89L).build());
        items.put(779989L, Item.builder().itemId(779989L).itemName("버드와이저 HOME DJing 굿즈 세트").itemPrice(35000L).itemStock(43L).build());
        items.put(779943L, Item.builder().itemId(779943L).itemName("Fabrik Pottery Flat Cup & Saucer - Mint").itemPrice(24900L).itemStock(89L).build());
        items.put(768110L, Item.builder().itemId(768110L).itemName("네페라 손 세정제 대용량 500ml 이더블유지 ").itemPrice(7000L).itemStock(79L).build());
        items.put(517643L, Item.builder().itemId(517643L).itemName("에어팟프로 AirPods PRO 블루투스 이어폰(MWP22KH/A)").itemPrice(260800L).itemStock(26L).build());
        items.put(706803L, Item.builder().itemId(706803L).itemName("ZEROVITY™ Flip Flop Cream 2.0 (Z-FF-CRAJ-)").itemPrice(38000L).itemStock(81L).build());
        items.put(759928L, Item.builder().itemId(759928L).itemName("마스크 스트랩 분실방지 오염방지 목걸이").itemPrice(2800L).itemStock(85L).build());
        items.put(213341L, Item.builder().itemId(213341L).itemName("20SS 오픈 카라/투 버튼 피케 티셔츠 (6color)").itemPrice(33250L).itemStock(99L).build());
        items.put(377169L, Item.builder().itemId(377169L).itemName("[29Edition.]_[스페셜구성] 뉴코튼베이직 브라렛 세트 (브라1+팬티2)").itemPrice(24900L).itemStock(60L).build());
        items.put(744775L, Item.builder().itemId(744775L).itemName("SHUT UP [TK00112]").itemPrice(28000L).itemStock(35L).build());
        items.put(779049L, Item.builder().itemId(779049L).itemName("[리퍼브/키친마켓] Fabrik Pottery Cup, Saucer (단품)").itemPrice(10000L).itemStock(64L).build());
        items.put(611019L, Item.builder().itemId(611019L).itemName("플루크 new 피그먼트 오버핏 반팔티셔츠 FST701 / 7color M").itemPrice(19800L).itemStock(7L).build());
        items.put(628066L, Item.builder().itemId(628066L).itemName("무설탕 프로틴 초콜릿 틴볼스").itemPrice(12900L).itemStock(8L).build());
        items.put(502480L, Item.builder().itemId(502480L).itemName("[29Edition.]_[스페셜구성] 렉시 브라렛 세트(브라1+팬티2)").itemPrice(24900L).itemStock(41L).build());
        items.put(782858L, Item.builder().itemId(782858L).itemName("폴로 랄프로렌 남성 수영복반바지 컬렉션 (51color)").itemPrice(39500L).itemStock(50L).build());
        items.put(760709L, Item.builder().itemId(760709L).itemName("파버카스텔 연필 1자루 ").itemPrice(200L).itemStock(70L).build());
        items.put(778422L, Item.builder().itemId(778422L).itemName("캠핑덕 우드롤테이블").itemPrice(45000L).itemStock(7L).build());
        items.put(648418L, Item.builder().itemId(648418L).itemName("BS 02-2A DAYPACK 26 (BLACK)").itemPrice(238000L).itemStock(5L).build());
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public List<Item> findItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public boolean orderItem(OrderItem response) {
        Item item = items.get(response.getItemId());
        if (!item.removeStock(response.getItemNumber())) {
            return false;
        }
        return true;
    }

    @Override
    public OrderItem findByItemId(OrderItemRequest request) {
        Item item = items.get(request.getItemId());
        return new OrderItem(item.getItemId(), item.getItemName(),item.getItemPrice(),item.getItemStock(),request.getItemNumber());
    }

    @Override
    public Item findById(Long itemId) {
        return items.get(itemId);
    }
}
