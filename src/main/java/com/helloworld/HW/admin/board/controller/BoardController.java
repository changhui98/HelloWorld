package com.helloworld.HW.admin.board.controller;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
public class BoardController {

    /**
     * 게시판 등록
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("requestBoardConfig", new RequestBoardConfig());

        return "admin/board/add";
    }

    @GetMapping("/list")
    public String list(){

        return "admin/board/list";
    }

}
