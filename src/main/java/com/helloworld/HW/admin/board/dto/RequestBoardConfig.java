package com.helloworld.HW.admin.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestBoardConfig {

    private String mode= "add";

    private String gid = UUID.randomUUID().toString();

    private boolean active; // 게시판 사용 여부

    @NotBlank
    private String bid; // 게시판 아이디

    @NotBlank
    private String category; // 게시판 카테고리

    @NotBlank
    private String bName; // 게시판 이름
}
