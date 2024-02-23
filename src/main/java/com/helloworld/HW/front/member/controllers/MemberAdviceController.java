package com.helloworld.HW.front.member.controllers;

import com.helloworld.HW.front.member.constants.EmployType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
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
     * 수정 -> RequestSkill 커맨드객체에서 피륻명을 가져와서 skillTypes에 넣음
     * @return
     */
    @ModelAttribute("skillTypes")
    public List<String> getSkillTypes(){
        /*
        RequestSkill skill = new RequestSkill();
        List<String> mySkill = new ArrayList<>();
        Field[] fields = skill.getClass().getDeclaredFields();
        for(Field field : fields){
            String fieldName = field.getName();
            mySkill.add(fieldName);
            System.out.println("어디갔니 " + fieldName);
        } */
        return Arrays.asList("java", "python", "htmlCss", "c", "csharpcplus", "js");
    }
}
