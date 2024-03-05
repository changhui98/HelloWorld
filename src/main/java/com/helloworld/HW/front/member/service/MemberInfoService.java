package com.helloworld.HW.front.member.service;

import com.helloworld.HW.front.member.dto.MemberInfo;
import com.helloworld.HW.front.member.entities.Authorities;
import com.helloworld.HW.front.member.entities.Member;
import com.helloworld.HW.front.member.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserDetailsService : 회원정보 조회 - 스프링 시큐리티 내에서 사용
 *  → MemberInfoService를 구현체로 만들 것임
 */
@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoService implements UserDetailsService {

   private final MemberRepository memberRepository;

    //회원 인증, 권한 체크 시 회원정보 조회할 때 사용
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

       //권한 가져오기
        List<Authorities> tmp = member.getAuthorities();
        if(tmp != null) {
            List<SimpleGrantedAuthority> authorities = tmp.stream()
                    .map(s -> new SimpleGrantedAuthority(s.getAuthority().name()))
                    .toList(); //enum -> String 가공
        }

        return MemberInfo.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .member(member)
                .build();
    }
}
