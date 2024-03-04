package com.helloworld.HW.config;

import com.helloworld.HW.front.member.service.LoginFailureHandler;
import com.helloworld.HW.front.member.service.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //시큐리티 로그인 무력화
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        /* 인증설정 S - 로그인, 회원가입 */
        http.formLogin(f -> { //로그인 설정 -> formLogin인터페이스 이용
            f.loginPage("/member/login") //로그인 페이지 처리
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(new LoginSuccessHandler()) //로그인 성공 후 처리 상세설정
                    .failureHandler(new LoginFailureHandler());

        });
        /* 인증설정 E - 로그인, 회원가입 */

        return http.build();
    }

    /**
     * BCrypt를 이용한 비밀번호 해시화 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
