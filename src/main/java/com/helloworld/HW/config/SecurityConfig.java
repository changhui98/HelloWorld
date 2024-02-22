package com.helloworld.HW.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //시큐리티 로그인 무력화
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        return http.build();
    }
}
