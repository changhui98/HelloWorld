package com.helloworld.HW.common.rests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

//JSONData의 형식을 고정
/** 성공시 데이터는 많을 것임
 * 이런 부분들은 setter를 통해 직접 하기보단
 * 객체를 만들 때 직접 바로 할 수 있게 생성자 매개변수를 추가,
 * 데이터가 없는 경우를 대비해 매개변수가 없는 생성자도 추가
 */
@NoArgsConstructor @AllArgsConstructor
@Data
public class JSONData<T> {
    private HttpStatus status = HttpStatus.OK; //기본 상태코드
    private boolean success = true; //성공여부 - 성공시가 기본 값
    private T data; //성공시 데이터
    private String message; //실패 시 메시지
}
