package com.helloworld.HW.common.exceptions;


import org.springframework.http.HttpStatus;

public class AlertException extends CommonException{
    public AlertException(String message, HttpStatus status) {
        super(message, status);
    }
}
