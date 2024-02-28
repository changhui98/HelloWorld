package com.helloworld.HW.admin.board.service;

import com.helloworld.HW.admin.board.dto.RequestBoardConfig;
import com.helloworld.HW.admin.board.entity.Board;
import com.helloworld.HW.admin.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시판 설정 조회
     *
     * @param bid
     * @return
     */
    public Board get(String bid){

        Board board = boardRepository.findById(bid).orElseThrow(BoardNotFoundException::new);

        return board;
    }

    public RequestBoardConfig getForm(String bid){
        Board board = get(bid);

        RequestBoardConfig form= new ModelMapper().map(board, RequestBoardConfig.class);

        form.setMode("edit");

        return form;
    }

    /**
     * 게시판 설정 리스트 조회 서비스
     *
     * @return
     */
    public List<Board> getlist(){

        List<Board> items = (List<Board>)boardRepository.findAll(Sort.by(desc("createdAt")));

        return items;
    }

    /**
     * 게시판 생성 서비스
     *
     * @param form
     */
    public void save(RequestBoardConfig form){
        String bid= form.getBid();
        String mode= form.getMode();

        mode= StringUtils.hasText(mode) ? mode : "add";

        Board board = boardRepository.findById(bid).orElseGet(Board::new);
        // 게시판 등록(mode= add)인 경우 bid, gid등록
        // 게시판 수정(mode= )인 경우 bid, gid 새로 등록하지 않음.
        if(mode.equals("add")){
            board.setBid(bid);
            board.setGid(form.getGid());
        }

        board.setActive(form.isActive());
        board.setCategory(form.getCategory());
        board.setBName(form.getBName());

        boardRepository.saveAndFlush(board);
    }

    public void delete(Board board){
        this.boardRepository.delete(board);
    }
}
