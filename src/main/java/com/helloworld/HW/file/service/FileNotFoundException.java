package com.helloworld.HW.file.service;

import com.helloworld.HW.common.Utils;
import com.helloworld.HW.common.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class FileNotFoundException extends CommonException {

    public FileNotFoundException(){
        super(Utils.getMessage("NotFound.file", "errors"), HttpStatus.NOT_FOUND);
    }
}
