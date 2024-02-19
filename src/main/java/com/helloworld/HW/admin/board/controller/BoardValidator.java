package com.helloworld.HW.admin.board.controller;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class BoardValidator implements Validator {

    private final BoardRepository boardRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestBoardConfig.class);
    }

    /**'
     * 게시판 아이디 중복 체크
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        RequestBoardConfig form = (RequestBoardConfig) target;

        String bid= form.getBid();
        String mode= form.getMode();
        if(mode.equals("add") && StringUtils.hasText(bid) && boardRepository.existsById(bid)) {
            errors.rejectValue("bid", "Duplicated");
        }
    }
}
