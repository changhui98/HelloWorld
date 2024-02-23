package com.helloworld.HW.common.validators;

public interface PasswordValidator {
    /**
     * 알파벳 포함 여부
     * @param password
     * @param caseIncensitive
     * @return
     */
    default boolean alphaCheck(String password, boolean caseIncensitive) {
        if(caseIncensitive) { //대소문자 구분없이
            String pattern=".*[a-zA-Z]+.*";
            return password.matches(pattern);

        } else { //대문자 1개 소문자 1개 이상
            String pattern1 = ".*[a-z]+.*";
            String pattern2 = ".*[A-Z]+.*";
            return password.matches(pattern1)&& password.matches(pattern2);
        }
    }

    /**
     * 숫자 포함여부체크
     * @param password
     * @return
     */
    default boolean numberCheck(String password) {
        return password.matches(".*\\d+.*");
    }

    default boolean specialCharsCheck(String password) {
        String pattern=".*[`~!@#$%^&*()_=-]+.*";
        return password.matches(pattern);
    }
}
