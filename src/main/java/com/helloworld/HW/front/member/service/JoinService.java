package com.helloworld.HW.front.member.service;

import com.helloworld.HW.front.member.MemberRepository;
import com.helloworld.HW.front.member.constants.SkillType;
import com.helloworld.HW.front.member.dto.RequestJoin;
import com.helloworld.HW.front.member.entities.Member;
import com.helloworld.HW.front.member.validator.JoinValidator;
import lombok.RequiredArgsConstructor;
import org. modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository memberRepository;
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

        System.out.println("스킬 :"+form.getSkill());
        String skills = form.getSkill().toString();

        //폼에서 받아와서 받아온 값에 skill엔티티의 필드와 일치하는 데이터가 있으면 true


  /*
        List<String> skills = form.getSkill();
        for ( String skill : skills ) {
            System.out.println(skillType);
            member.setSkill(skillType);
        }
   */

        process(member);
    }

    public void process(Member member) {
        memberRepository.saveAndFlush(member);
    }
}
