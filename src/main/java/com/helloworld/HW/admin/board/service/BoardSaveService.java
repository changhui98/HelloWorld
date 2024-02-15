package com.helloworld.HW.admin.board.service;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.entity.Board;
import com.helloworld.HW.admin.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardRepository boardRepository;

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
