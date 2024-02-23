package com.helloworld.HW.common.validators;

public interface PasswordValidator {
    /**
     * 알파벳 포함 여부
     * @param password
     * @param caseIncensitive
     * @return
     */
    default boolean alphaCheck(String password, boolean caseIncensitive) {
        /**
         * []:문자 클래스 - 문자 한개한개를 의미
         * [abc]: a가 포함되어있는지, b가 포함되어있는지, c가 포함되어 있는지 체크
         * + : 1개 이상 = {1,} = 최대 매칭
         * * : 0개 이상 = {0,} = 최소 매칭
         * ? : 문자 1개, 있어도 좋고 없어도 좋음 {0,1}
         * 패턴 {2} : 패턴이 2번 반복
         * 패턴{2,} : 패턴이 2번 이상 반복
         * 패턴 {2,5} -> 패턴이 2번 이상 5번 이하 반복
         * \d = [0-9] -> 숫자인 패턴
         * \D = [^0-9] -> 숫자가 아닌 패턴
         * [^0-9] -> 0-9 숫자가 포함되지 않은 문자
         * \s : 공백 1개
         * \S : 공백이 아닌 문자 1개
         * \w : [a-zA-Z_] : 단어에 포함될 수 있는 문자...? 단어 하나
         * \W : 위에꺼 제외...
         *
         * <참고>
         *     문자 클래스 외부
         *     ^abc -> abc로 시작하는 패턴
         *     xyz$ -> xyz로 끝나는 패턴
         * </참고>
         */
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
