package com.helloworld.HW.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class Utils {

    private final static ResourceBundle commonsBundle;
    private final static ResourceBundle errorsBundle;
    private final static ResourceBundle validationsBundle;

    static {
        commonsBundle = ResourceBundle.getBundle("messages.commons");
        errorsBundle = ResourceBundle.getBundle("messages.errors");
        validationsBundle = ResourceBundle.getBundle("messages.validations");
    }

    public static String getMessage(String code, String type){
        try{
            //오타수정
            type= StringUtils.hasText(type) ? type : "validations";

            ResourceBundle bundle= null;
            if(type.equals("commons")){
                bundle= commonsBundle;
            }else if (type.equals("errors")){
                bundle= errorsBundle;
            }else {
                bundle= validationsBundle;
            }
            return bundle.getString(code);

        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMessage(String code){
        return getMessage(code, null);
    }
}
