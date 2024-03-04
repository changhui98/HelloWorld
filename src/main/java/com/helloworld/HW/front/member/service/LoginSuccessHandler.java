package com.helloworld.HW.front.member.service;

import com.helloworld.HW.front.member.MemberUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        //성공시 메시지 데이터 비워주기
        HttpSession session = request.getSession();
        MemberUtil.clearLoginData(session);

        String redirectURL = request.getParameter("redirectURL");
        //쿼리스트링 값이 없으면 메인페이지로
        redirectURL = StringUtils.hasText(redirectURL) ? redirectURL : "/";

        response.sendRedirect(request.getContextPath() + redirectURL);
    }
}
