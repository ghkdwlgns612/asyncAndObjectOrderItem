package com.example.kr.co._29cm.homework;

import com.example.kr.co._29cm.homework.domain.dto.OrderItem;
import com.example.kr.co._29cm.homework.repository.InMemoryItemRepository;
import com.example.kr.co._29cm.homework.repository.ItemRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {

	private ItemRepository itemRepository = new InMemoryItemRepository();

	@BeforeAll
	void init() {
		itemRepository.init();
	}

	@Test
	@DisplayName("첫 번째 요청에서 장바구니에 담고 결제가 완료하지 않은 상태에서 두 번째 요청이 그 아이템에 접근하여 결제를 완료하고 재고를 감소시킬 때 SoldOut예외가 잘 발생하는지 확인하는 테스트")
	void givenFirstThread_whenSecondThreadRequestSuccess_thenSoldOutExceptionOccur() throws Exception {
		OrderItem item = new OrderItem(768848L,"[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종",21000L,45L,30L);
		CountDownLatch latch = new CountDownLatch(2);

		Thread first = new Thread(() -> {
			try {
				System.out.println("첫 번째 주문쓰레드 열기");
				Thread.sleep(3000);
				itemRepository.orderItem(item);
				System.out.println();
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread second = new Thread(() -> {
			try {
				System.out.println("두 번째 주문쓰레드 열기");
				itemRepository.orderItem(item);
				System.out.println("두 번째 주문쓰레드 결제완료");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		first.start();
		second.start();

		latch.await();

		//주문을 두 번째 쓰레드에서 30개했고 첫 번째 쓰레드에서는 주문 실패가 뜨고 잔량은 그대로 있어야하므로 15개가 남아있어야함.
		Assertions.assertEquals(15L,itemRepository.findById(768848L).getItemStock());
	}
}
