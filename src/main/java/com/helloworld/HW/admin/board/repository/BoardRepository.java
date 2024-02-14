package com.helloworld.HW.admin.board.repository;

import com.helloworld.HW.admin.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {
}
