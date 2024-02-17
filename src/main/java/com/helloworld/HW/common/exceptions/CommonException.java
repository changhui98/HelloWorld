package com.helloworld.HW.common.exceptions;

import org.springframework.http.HttpStatus;

//모든 예외를 정의해 줄 클래스 (사용자 정의 예외 클래스)
public class CommonException extends RuntimeException{
    private HttpStatus status; //예외 발생시 HTTP 응답코드 저장

    //생성자
    public CommonException(String message, HttpStatus status) {
        super(message); //매개변수로 받은 message를 부모클래스인 RuntimeCxcption에 전달
        this.status = status;
    }

    //응답코드 가져오기
    public HttpStatus getStatus() {
        return status;
    }
}
