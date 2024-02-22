package com.helloworld.HW.front.member.entities;

import com.helloworld.HW.common.entity.BaseDate;
import com.helloworld.HW.front.member.constants.SkillType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Member extends BaseDate {
    @Id @GeneratedValue
    private Long userNo; //기본키
    @Column(length=80, nullable = false, unique = true)
    private String email;

    @Column(length=40, nullable = false, unique = true)
    private String password;

    @Column(length=24, nullable = false, unique = true) //닉네임 8글자 제한
    private String nickname;

    private boolean employed; //개발자? 개발자준비생?

    @Enumerated(EnumType.STRING)
    @Column(length=25, nullable = true)
    private SkillType skill; //사용언어 <- SkillType EnumClass
}
