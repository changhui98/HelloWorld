package com.helloworld.HW.front.member;

import com.helloworld.HW.front.member.entities.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final HttpSession session;

    //회원 데이터 조회
    public Member getMember() {
        Member member = (Member)session.getAttribute("member");
        System.out.println("MemberUtil에서 member에 담겼니??!~" + member);
        return member;
    }

    //로그인 여부 체크
    public boolean isLogin() {
        System.out.println("로그인 여부 체크 되니?!");
        return getMember() != null;
    }


    //로그인 세션 비우기
    public static void clearLoginData(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("NotBlank_username");
        session.removeAttribute("NotBlank_password");
        session.removeAttribute("Global_error");
    }
}
