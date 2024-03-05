package com.helloworld.HW.common.interceptors;

import com.helloworld.HW.front.member.MemberUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        clearLoginData(request);
        return true;
    }

    /**
     * 검증 메시지 초기화
     * @param request
     */
    private void clearLoginData(HttpServletRequest request) {
        String URL = request.getRequestURI();
        System.out.println(URL);
        //login페이지가 아니면 세션 초기화
        System.out.println(URL.indexOf("/member/login"));
        if(URL.indexOf("/member/login") == -1) {
            HttpSession session = request.getSession();
            MemberUtil.clearLoginData(session);
        }
    }
}
