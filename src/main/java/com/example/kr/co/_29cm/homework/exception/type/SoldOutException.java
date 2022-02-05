package com.example.kr.co._29cm.homework.exception.type;

import com.example.kr.co._29cm.homework.exception.BusinessException;
import com.example.kr.co._29cm.homework.exception.ErrorCode;

public class SoldOutException extends BusinessException {
    public SoldOutException() {
        super(ErrorCode.SOLD_OUT);
    }
}
