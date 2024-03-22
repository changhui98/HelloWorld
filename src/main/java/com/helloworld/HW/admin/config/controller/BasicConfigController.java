package com.helloworld.HW.admin.config.controller;

import ch.qos.logback.core.model.Model;
import com.helloworld.HW.admin.config.dto.BasicConfig;
import com.helloworld.HW.common.ExceptionProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/config")
@RequiredArgsConstructor
public class BasicConfigController implements ExceptionProcessor {

    @ModelAttribute("menuCode")
    public String getMenuCode(){
        return "config";
    }

    @GetMapping
    public String index(@ModelAttribute BasicConfig config, Model model){

        return "admin/config/basic";
    }

    @PostMapping
    public String save(BasicConfig config, Model model){

        return "admin/config/basic";
    }

}