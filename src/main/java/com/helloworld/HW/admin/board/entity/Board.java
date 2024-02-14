package com.helloworld.HW.admin.board.entity;

import com.helloworld.HW.common.entity.BaseDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class Board extends BaseDate {

    @Id
    @Column(length = 30)
    private String bid; // 게시판 아이디

    private String gid = UUID.randomUUID().toString();

    @Column(length = 60, nullable = false)
    private String category; // 게시판 카테고리

    @Lob
    private String bName; // 게시판 하위 분류 이름

    private boolean active; // 게시판 사용 여부
}
