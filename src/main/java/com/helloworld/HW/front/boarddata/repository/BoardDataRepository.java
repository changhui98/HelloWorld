package com.helloworld.HW.front.boarddata.repository;

import com.helloworld.HW.front.boarddata.entity.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {


}
