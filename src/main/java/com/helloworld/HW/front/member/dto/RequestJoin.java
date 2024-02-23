package com.helloworld.HW.front.member.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

//요청데이터를 처리할 커맨드 객체
@Data
public class RequestJoin {
    @NotBlank @Email //@Email: 이메일 형식을 검증할 수 있음
    private String email;

    @NotBlank
    @Size(min=8)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String nickname;

    @AssertTrue
    private boolean agree; //약관 동의


    private List<String> skill; //보유스킬

    private String employed; //님 개발자임? 준비생임? 학생임?




}
