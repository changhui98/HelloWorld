package com.helloworld.HW.front.member.constants;

import com.helloworld.HW.common.Utils;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public enum SkillType {
    TYPE_JAVA(Utils.getMessage("SkillType.TYPE_JAVA", "commons")),
    TYPE_PYTHON(Utils.getMessage("SkillType.TYPE_PYTHON","commons")),
    TYPE_C(Utils.getMessage("SkillType.TYPE_C","commons")),
    TYPE_CSHARPCPLUS(Utils.getMessage("SkillType.TYPE_CSHARTCPLUS","commons")), //C#C++
    TYPE_JS(Utils.getMessage("SkillType.TYPE_JS","commons")),
    TYPE_HTMLCSS(Utils.getMessage("SkillType.TYPE_HTMLCSS","commons")); // HTML/CSS





    private final String title;
    SkillType(String title) {
        this.title=title;
    }

    public static List<String[]> getList() {

        return Arrays.asList(
                new String[] { TYPE_JAVA.name(), TYPE_JAVA.title },
                new String[] {TYPE_PYTHON.name(), TYPE_PYTHON.title},
                new String[] {TYPE_C.name(), TYPE_C.title},
                new String[] {TYPE_CSHARPCPLUS.name(), TYPE_CSHARPCPLUS.title},
                new String[] {TYPE_JS.name(), TYPE_JS.title},
                new String[] {TYPE_HTMLCSS.name(), TYPE_HTMLCSS.title}
        );
    }

    public String getTitle() {
        return title;
    }
}
