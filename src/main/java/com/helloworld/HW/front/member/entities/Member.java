package com.helloworld.HW.front.member.entities;

import com.helloworld.HW.common.entity.BaseDate;
import com.helloworld.HW.front.member.constants.EmployType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class Member extends BaseDate {
    @Id @GeneratedValue
    private Long userNo; //기본키
    @Column(length=80, nullable = false, unique = true)
    private String email;

    @Column(length=80, nullable = false, unique = true)
    private String password;

    @Column(length=24, nullable = false, unique = true) //닉네임 8글자 제한
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length=25)
    private EmployType employed; //개발자? 개발자준비생?


    @Column
    private String skill; //사용언어 <- SkillType EnumClass

    public List<String> getSkills() {
        if (!StringUtils.hasText(skill)) return null;

        return Arrays.stream(skill.split(",")).toList();
    }
    @ToString.Exclude //해당 필드 포함X (순환 참조 방지)
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //주인 명시
    private List<Authorities> authorities = new ArrayList<>();
}
