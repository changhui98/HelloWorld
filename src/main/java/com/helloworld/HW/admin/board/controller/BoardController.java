package com.helloworld.HW.admin.board.controller;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.entity.Board;
import com.helloworld.HW.admin.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
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

    @GetMapping("/edit/{bid}")
    public String edit(@PathVariable("bid") String bid, Model model){

        RequestBoardConfig form= boardService.getForm(bid);
        model.addAttribute("requestBoardConfig", form);

        return "admin/board/edit";
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
        String mode= config.getMode();

        boardValidator.validate(config, errors);

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(System.out::println);
            return "admin/board/" + mode;
        }

        boardService.save(config);

        return "redirect:/admin/board/list";
    }

    /**
     * 게시판 조회 처리
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model){

        List<Board> items = boardService.getlist();
        model.addAttribute("items", items);

        return "admin/board/list";
    }

    @GetMapping("/delete/{bid}")
    public String delete(@PathVariable("bid") String bid ){
        Board board = boardService.get(bid);

        this.boardService.delete(board);

        return "redirect:/admin/board/list";
    }


}
