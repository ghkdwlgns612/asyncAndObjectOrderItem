package com.example.kr.co._29cm.homework.exception;

import com.example.kr.co._29cm.homework.exception.type.SoldOutException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SoldOutException.class)
    protected void handleSoldOutException() {
        System.out.println("SoldOutException발생. 주문한 상품량이 재고량보다 큽니다.");
    }
}
