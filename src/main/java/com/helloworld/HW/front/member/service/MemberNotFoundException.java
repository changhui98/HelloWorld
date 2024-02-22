package com.helloworld.HW.front.member.service;

import com.helloworld.HW.common.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CommonException {

    public MemberNotFoundException() {
        super("등록된 회원이 아닙니다.", HttpStatus.NOT_FOUND);
    }
}
