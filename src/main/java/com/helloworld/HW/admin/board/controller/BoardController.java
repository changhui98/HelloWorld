package com.helloworld.HW.admin.board.controller;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.service.BoardSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService boardSaveService;

    /**
     * 게시판 관리자 메인 페이지
     *
     * @return
     */
    @GetMapping
    public String index(Model model){


        return "admin/board/board";
    }


    /**
     * 게시판 등록
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(@ModelAttribute RequestBoardConfig config, Model model){

        return "admin/board/add";
    }

    @PostMapping("/save")
    public String save(RequestBoardConfig config, Model model){

        boardSaveService.save(config);

        return "admin/board/list";
    }

    @GetMapping("/list")
    public String list(){

        return "admin/board/list";
    }

}
