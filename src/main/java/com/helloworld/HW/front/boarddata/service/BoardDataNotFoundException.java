package com.helloworld.HW.front.boarddata.service;

import com.helloworld.HW.common.Utils;
import com.helloworld.HW.common.exceptions.AlertBackException;
import org.springframework.http.HttpStatus;

public class BoardDataNotFoundException extends AlertBackException {

    public BoardDataNotFoundException(){

        super(Utils.getMessage("NotFound.boardData", "errors"), HttpStatus.NOT_FOUND);
    }
}
