package com.helloworld.HW.admin.board.service;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.entity.Board;
import com.helloworld.HW.admin.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시판 조회 서비스
     *
     * @return
     */
    public List<Board> getlist(){

        List<Board> items = (List<Board>)boardRepository.findAll();

        return items;
    }

    /**
     * 게시판 생성 서비스
     *
     * @param form
     */
    public void save(RequestBoardConfig form){
        String bid= form.getBid();
        Board board = new Board();
        board.setBid(bid);
        board.setGid(form.getGid());
        board.setActive(form.isActive());
        board.setCategory(form.getCategory());
        board.setBName(form.getBName());

        boardRepository.saveAndFlush(board);
    }
}
