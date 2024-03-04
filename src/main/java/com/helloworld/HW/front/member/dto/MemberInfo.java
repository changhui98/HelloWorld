package com.helloworld.HW.front.member.dto;

import com.helloworld.HW.front.member.entities.Member;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class MemberInfo implements UserDetails {

    //기본정보
    private String email;
    private String password;
    private Member member;

    private Collection<? extends GrantedAuthority> authorities;

    //특정 권한에 대한 인가(괸리자 or 멤버 or ...)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }



    //비밀번호 - 로그인시 이용
    @Override
    public String getPassword() {
        return password;
    }

    //ID - 로그인시 이용
    @Override
    public String getUsername() {
        return email;
    }

    //계정이 만료되지 않은 상태인가?
    @Override
    public boolean isAccountNonExpired() {
        return true; //임시
    }

    //계정이 잠겨있지 않는가?
    @Override
    public boolean isAccountNonLocked() {
        return true; //임시
    }


    //비밀번호가 만료되지 않은 상태인가?
    @Override
    public boolean isCredentialsNonExpired() {
        return true; //임시
    }


    //탈퇴여부? false: 탈퇴
    @Override
    public boolean isEnabled() {
        return true;
    }
}
