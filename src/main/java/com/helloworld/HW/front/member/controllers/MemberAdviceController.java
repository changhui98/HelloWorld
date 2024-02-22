package com.helloworld.HW.front.member.controllers;

import com.helloworld.HW.front.member.constants.EmployType;
import com.helloworld.HW.front.member.constants.SkillType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice("com.helloworld")
public class MemberAdviceController {
    /**
     * EmployType enum클래스에서 enum 상수들을 가져와 employTypes에 넣음 -> 뷰에 전달
     * @return
     */
    @ModelAttribute("employTypes")
    public List<String[]> getEmployTypes(){
        return EmployType.getList();
    }

    /**
     * SkillType enum클래스에서 enum 상수들을 가져와 skillTypes에 넣음 -> 뷰에 전달
     * @return
     */
    @ModelAttribute("skillTypes")
    public List<String[]> getSkillTypes(){
        return SkillType.getList();
    }
}
