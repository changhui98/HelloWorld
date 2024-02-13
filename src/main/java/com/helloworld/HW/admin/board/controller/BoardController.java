package com.helloworld.HW.admin.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
public class BoardController {


    @GetMapping("/add")
    public String add(){

        return "admin/board/add";
    }

    @GetMapping("/list")
    public String list(){

        return "admin/board/list";
    }

}
