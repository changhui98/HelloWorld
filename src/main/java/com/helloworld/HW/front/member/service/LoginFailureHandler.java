package com.helloworld.HW.front.member.service;

import com.helloworld.HW.common.Utils;
import com.helloworld.HW.front.member.MemberUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;

//로그인 인증 실패시 유입
public class LoginFailureHandler implements AuthenticationFailureHandler {

    //실패 원인 알려주고, 다시 로그인페이지로 이동하기
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        /**
         * 검증메시지
         *         ID, 비밀번호 가져오기 - 실패시 메시지 출력
         *         템플릿에 출력할 데이터 전달은 속성을 통해 전달,
         *         but sendredirect를 통한 이동은
         *         request를 통해 데이터를 전송하면 유지가 안됨 ,
         *         따라서 request보다 더 범위가 큰 session 혹은 application 이용
         */
        HttpSession session = request.getSession(); //요청 쪽에서 세션 정보 조회

        //로그인 실패시 검증 메시지 일괄 삭제
        MemberUtil.clearLoginData(session);


        //아이디, 비밀번호 가져오기
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //로그인 실패시 입력한 아이디 유지
        session.setAttribute("username", username);
        
        //세션에 담아서 메시지 출력
        if(!StringUtils.hasText(username)) { //아이디가 없을 때
            session.setAttribute("NotBlank_username",
                    Utils.getMessage("NotBlank.email"));
        }
        if(!StringUtils.hasText(password)) { //비밀번호 X
            session.setAttribute("NotBlank_password",
                    Utils.getMessage("NotBlank.password"));
        }

        //아이디로 조회되는 회원이 없거나 비밀번호 불일치시
        if(StringUtils.hasText(username) && StringUtils.hasText(password)) {
            session.setAttribute("Global_error", Utils.getMessage("Fail.login",
                    "errors"));
        }

        //실패 시 다시 로그인 페이지로
        response.sendRedirect(request.getContextPath() + "/member/login");
    }
}
