package com.helloworld.HW.front.member.constants;

import com.helloworld.HW.common.Utils;

import java.util.Arrays;
import java.util.List;

public enum EmployType {
    TYPE_EMPLOYED(Utils.getMessage("EmployType.TYPE_EMPLOYED","commons")),
    TYPE_UNEMPLOYED(Utils.getMessage("EmployType.TYPE_UNEMPLOYED","commons")),
    TYPE_STUDENT(Utils.getMessage("EmployType.TYPE_STUDENT","commons"));

    private final String title;

    EmployType(String title) {
        this.title=title;
    }

    public static List<String[]> getList() {
        return Arrays.asList(
                new String[] { TYPE_EMPLOYED.name(), TYPE_EMPLOYED.title },
                new String[] { TYPE_UNEMPLOYED.name(), TYPE_UNEMPLOYED.title },
                new String[] { TYPE_STUDENT.name(), TYPE_STUDENT.title }

        );
    }

    public String getTitle() {
        return title;
    }
}
