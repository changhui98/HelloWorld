package com.helloworld.HW.front.member.service;

import com.helloworld.HW.front.member.constants.Authority;
import com.helloworld.HW.front.member.constants.EmployType;
import com.helloworld.HW.front.member.dto.RequestJoin;
import com.helloworld.HW.front.member.entities.Authorities;
import com.helloworld.HW.front.member.entities.Member;
import com.helloworld.HW.front.member.repositories.AuthoritiesRepository;
import com.helloworld.HW.front.member.repositories.MemberRepository;
import com.helloworld.HW.front.member.validator.JoinValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinService {

    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final JoinValidator joinValidator;
    private final PasswordEncoder encoder;

    public void process(RequestJoin form, Errors errors){
        joinValidator.validate(form, errors);
        if(errors.hasErrors()) {
            return;
        }

        //가입처리
        String hash = encoder.encode(form.getPassword()); //비밀번호 해시화

        Member member = new ModelMapper().map(form, Member.class); //데이터 치환

        member.setPassword(hash); //비밀번호는 해시화한 형태로 바뀌어있으므로 직접 넣어줌

        //스킬 데이터 가공
        List<String> skills = form.getSkill();
        String skill = skills == null || skills.isEmpty() ? null : skills.stream().collect(Collectors.joining(","));
        member.setSkill(skill);
        //폼에서 받아와서 받아온 값에 skill엔티티의 필드와 일치하는 데이터가 있으면 true

        EmployType type = EmployType.valueOf(form.getEmployed());
        member.setEmployed(type);

        process(member);

        //회원가입시 일반 회원 권한 부여(USER)
        Authorities authorities = new Authorities();
        authorities.setMember(member);
        authorities.setAuthority(Authority.USER);
        authoritiesRepository.saveAndFlush(authorities);

    }

    public void process(Member member) {
        memberRepository.saveAndFlush(member);
    }
}
