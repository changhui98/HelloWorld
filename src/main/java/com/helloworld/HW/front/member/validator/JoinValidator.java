package com.helloworld.HW.front.member.validator;

import com.helloworld.HW.common.validators.PasswordValidator;
import com.helloworld.HW.front.member.MemberRepository;
import com.helloworld.HW.front.member.dto.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 커맨드 객체 2차 검증
 */
@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator, PasswordValidator {

    private final MemberRepository memberRepository;

    /**
     * 검증대상 한정
     * 매개변수로 받은 class가
     * RequestJoin과 일치 or RquestJoin의 하위 클래스인지를 판별
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 이메일 중복 여부 체크
         * 2. 비밀번호 복잡성 체크 - 대소문자 1개 각각 포함, 숫자 1개 이상 포함, 특수문자 1개 이상 포함
         * 3. 비밀번호, 비밀번호 확인 일치 여부 체크
         * 4. 닉네임 중복 여부체크
         */
        RequestJoin form = (RequestJoin)target;
        String email = form.getEmail();
        String nickname = form.getNickname();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();

        //1. 이메일 중복 여부 체크;
        if(StringUtils.hasText(email) && memberRepository.existsByEmail(email)) {
            errors.rejectValue("email","Duplicated");
        }

        if(StringUtils.hasText(nickname) && memberRepository.existsByNickname(nickname)) {
            errors.rejectValue("nickname", "Duplicated");
        }

        //2. 비밀번호 복잡성 체크 - 알파벳 대소문자 1개씩, 숫자 1개, 특수문자 1개
        if(StringUtils.hasText(password) &&
                (!alphaCheck(password,false) ||
                 !numberCheck(password) ||
                 !specialCharsCheck(password))) {
            errors.rejectValue("password", "Complexity");
        }

        //3. 비밀번호, 비밀번호 확인 일치여부 체크
        if(StringUtils.hasText(password) && StringUtils.hasText(confirmPassword)
        &&!password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Mismatch.password");
        }
    }
}
