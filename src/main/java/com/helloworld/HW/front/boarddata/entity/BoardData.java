package com.helloworld.HW.front.boarddata.entity;

import com.helloworld.HW.admin.board.entity.Board;
import com.helloworld.HW.common.entity.BaseMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardData extends BaseMember {

    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne
    @JoinColumn(name= "bid")
    private Board board;

    private String gid = UUID.randomUUID().toString();

    private String bName; // 글 카테고리

    private String subject; // 글 제목

    private String content; // 글 내용

    private int viewCount; // 글 조회수

}
