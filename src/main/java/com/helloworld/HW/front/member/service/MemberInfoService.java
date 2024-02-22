package com.helloworld.HW.front.member.service;

import com.helloworld.HW.front.member.MemberRepository;
import com.helloworld.HW.front.member.dto.MemberInfo;
import com.helloworld.HW.front.member.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService : 회원정보 조회 - 스프링 시큐리티 내에서 사용
 *  → MemberInfoService를 구현체로 만들 것임
 */
@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {

   private final MemberRepository memberRepository;

    //회원 인증, 권한 체크 시 회원정보 조회할 때 사용
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(username).orElseThrow(MemberNotFoundException::new);
        return MemberInfo.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .member(member)
                .build();
    }
}
