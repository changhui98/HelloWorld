package com.helloworld.HW.front.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//메인 페이지 회원 관련 컨트롤러
@Controller
@RequestMapping("/member")
public class MemberController {

    /**
     * 회원가입
     * @return 회원가입 템플릿 연결
     */
    @GetMapping("/join")
   public String join() {
       return "front/member/join";
   }

    /**
     * 로그인
     * @return 로그인 템플릿 연결
     */
   @GetMapping("/login")
    public String login() {
        return "front/member/login";
   }
}
