package com.example.kr.co._29cm.homework.exception;

public enum ErrorCode {
    SOLD_OUT(4040, "SoldOutException발생. 주문한 상품량이 재고량보다 큽니다.");

    private final int code;
    private final String message;

    ErrorCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return code;
    }
}