package com.helloworld.HW.front.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class MemberUtil {
    //로그인 세션 비우기
    public static void clearLoginData(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("NotBlank_username");
        session.removeAttribute("NotBlank_password");
        session.removeAttribute("Global_error");
    }
}
