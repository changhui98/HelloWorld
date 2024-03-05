package com.helloworld.HW.front.boarddata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardDataController {

    @GetMapping("/{bid}")
    public String list(@PathVariable("bid") String bid,
                       Model model){



        return "/front/member/join/{bid}";

    }

}
