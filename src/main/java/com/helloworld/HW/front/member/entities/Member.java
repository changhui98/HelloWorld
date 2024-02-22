package com.helloworld.HW.front.member.entities;

import com.helloworld.HW.common.entity.BaseDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member extends BaseDate {
    @Id @GeneratedValue
    private Long userNo;

    private String email;

    private String password;

    private String nickname;

    private boolean employed; //개발자? 개발자준비생?

    private String skill; //사용언어 -> enum클래스로 뺄 예정
}
