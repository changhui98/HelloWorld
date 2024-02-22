package com.helloworld.HW.common;

import com.helloworld.HW.common.exceptions.CommonException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

//controllers 범위 안에 발생한 예외를 모두 받을 인터페이스
public interface ExceptionProcessor {

    //응답코드 가져오기 (HttpServletResponse 객체)
    @ExceptionHandler(Exception.class)
    default String errorHandler(Exception e, HttpServletResponse response, HttpServletRequest request, Model model) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //기본값 500

        //CommonException일 때만 유입
        if ( e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus(); //각 예외에 따라 응답코드 가져 옴
        }

        response.setStatus(status.value()); //응답코드 설정
        e.printStackTrace();//콘솔에 에러 출력

        model.addAttribute("status", status.value());
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("method", request.getMethod());
        model.addAttribute("message", e.getMessage());
        return "error/common";
    }

}
