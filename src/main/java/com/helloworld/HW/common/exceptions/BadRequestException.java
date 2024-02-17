package com.helloworld.HW.common.exceptions;

import org.springframework.http.HttpStatus;

//400 에러 정의
public class BadRequestException extends CommonException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
