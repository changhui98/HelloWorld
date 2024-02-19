package com.helloworld.HW.front.boarddata.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestBoardData {

    private String mode= "write";
    private Long seq; // 게시글 번호
    private String bid; // 게시판 ID
    private String gid= UUID.randomUUID().toString();

    private String bName; // 게시판 분류

    private String subject; // 글 제목
    private String content; // 글 내용

}
