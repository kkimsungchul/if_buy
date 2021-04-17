package com.sungchul.ifbuy.board.domain.repository;

import com.sungchul.ifbuy.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
}
