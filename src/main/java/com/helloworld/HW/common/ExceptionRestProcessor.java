package com.helloworld.HW.common;

import com.helloworld.HW.common.exceptions.CommonException;
import com.helloworld.HW.common.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//rest 컨트롤러의 공통에러 처리 - 형식은 json방식으로 통일
public interface ExceptionRestProcessor {
    //ResponseEntity = HTTP응답
    @ExceptionHandler(Exception.class) //Exception 에러를 처리할 것임
    default ResponseEntity<JSONData<Object>> errorHandler(Exception e) {
        //기본값 500
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        //responseEntity를 통해 응답코드를 가져오고, JSON 클래스의 인스턴스를 생성하여 할당
        JSONData<Object> data = new JSONData<>();
        //실패시 데이터 설정
        data.setSuccess(false);
        data.setStatus(status);
        data.setMessage(e.getMessage());

        e.printStackTrace();

        //응답코드와 함께 바디를 통해 데이터출력 - JSON 형태로 출력
        return ResponseEntity.status(status).body(data);
    }
}
