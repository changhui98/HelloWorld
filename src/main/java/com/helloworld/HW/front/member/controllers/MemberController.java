package com.helloworld.HW.front.member.controllers;

import com.helloworld.HW.common.ExceptionProcessor;
import com.helloworld.HW.front.member.dto.RequestJoin;
import com.helloworld.HW.front.member.service.JoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//메인 페이지 회원 관련 컨트롤러
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController implements ExceptionProcessor {

    private final JoinService joinService;
    /**
     * 회원가입
     * @return 회원가입 템플릿 연결
     */
    @GetMapping("/join")
   public String join(@ModelAttribute RequestJoin form) {
       return "front/member/join";
   }

   @PostMapping("/join")
   public String joinPs(@Valid RequestJoin form, Errors errors) {

        //2차 검증
        joinService.process(form, errors);
        //성공시 로그인 페이지, 실패시 다시 회원가입 템플릿 보여줌
        if(errors.hasErrors()) {
            return ("front/member/join");
        }
        return "redirect:/member/login";
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
