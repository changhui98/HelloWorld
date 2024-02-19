package com.helloworld.HW.admin.board.service;

import com.helloworld.HW.common.Utils;
import com.helloworld.HW.common.exceptions.AlertBackException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends AlertBackException {

    public BoardNotFoundException(){
        super(Utils.getMessage("NotFound.board", "errors"), HttpStatus.NOT_FOUND);
    }
}
