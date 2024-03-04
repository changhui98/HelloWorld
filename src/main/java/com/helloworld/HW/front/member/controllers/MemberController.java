package com.helloworld.HW.front.member.controllers;

import com.helloworld.HW.common.ExceptionProcessor;
import com.helloworld.HW.front.member.MemberUtil;
import com.helloworld.HW.front.member.dto.RequestJoin;
import com.helloworld.HW.front.member.entities.Member;
import com.helloworld.HW.front.member.service.JoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

//메인 페이지 회원 관련 컨트롤러
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController implements ExceptionProcessor {

    private final JoinService joinService;
    private final MemberUtil memberUtil; //회원정보 조회, 로그인 여부 체크 위해
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


   //로그인 시 회원정보 보여주기 / 미로그인시 미로그인 상태라고 알려주기
    @ResponseBody
    @GetMapping("/info")
    public void info() {
        System.out.println("나 member/info에 가고싶어...");
       if(memberUtil.isLogin()) {
            Member member = memberUtil.getMember();
           System.out.println(member);
       } else {
           System.out.println("미로그인 상태");
       }
   }
}
