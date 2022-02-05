package com.example.kr.co._29cm.homework;

import com.example.kr.co._29cm.homework.repository.ItemRepository;
import com.example.kr.co._29cm.homework.service.orderService.OrderService;
import com.example.kr.co._29cm.homework.service.orderFactory.OrderServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Scanner;

@SpringBootApplication
@EnableAsync
public class Application {

	private static OrderServiceFactory orderServiceFactory;
	private static ItemRepository itemRepository;

	@Autowired
	public Application(OrderServiceFactory orderServiceFactory, ItemRepository itemRepository) {
		this.orderServiceFactory = orderServiceFactory;
		this.itemRepository = itemRepository;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class);
		itemRepository.init();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("입력(o[order] : 주문, q[quit]: 종료) : ");
			String command = scanner.next();

			OrderService orderService = orderServiceFactory.getOrderService(command);

			orderService.orderItem();
		}
	}
}
