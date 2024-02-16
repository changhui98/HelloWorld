package com.helloworld.HW.admin.board.controller;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.service.BoardSaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService boardSaveService;
    private final BoardValidator boardValidator;

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
     * 게시판 등록 페이지 템플릿 출력
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(@ModelAttribute RequestBoardConfig config, Model model){

        return "admin/board/add";
    }

    /**
     * 게시판 등록 처리
     *
     * @param config
     * @param errors
     * @param model
     * @return
     */
    @PostMapping("/save")
    public String save(@Valid RequestBoardConfig config, Errors errors, Model model){

        boardValidator.validate(config, errors);
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(System.out::println);
            return "admin/board/add";
        }

        boardSaveService.save(config);

        return "admin/board/list";
    }

    @GetMapping("/list")
    public String list(){

        return "admin/board/list";
    }

}
