package com.example.shop.controller;

import com.example.shop.entity.BoardEntity;
import com.example.shop.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardControllerTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    // 입력
    @Test
    @Order(1)
    @Rollback(value = false)
     void save() {

        BoardEntity boardEntity = BoardEntity.builder()
                .boardWriter("1")
                .boardTitle("1")
                .boardContents("1")
                .boardPass("1")
                .boardHits(1)
                .build();
        boardRepository.save(boardEntity);

        Assertions.assertThat(boardEntity.getId()).isGreaterThan(0);
    }

    // 전체 조회
    @Test
    @Order(2)
    void findAll(){

        List<BoardEntity> boardEntity = boardRepository.findAll();

        Assertions.assertThat(boardEntity.size()).isGreaterThan(0); // 사이즈가 0보다 크면 실행

    }

    // 1건 조회
    @Test
    @Order(3)
    void findById(){

        BoardEntity boardEntity = boardRepository.findById(1L).get();

        Assertions.assertThat(boardEntity.getId()).isEqualTo(1L);
    }

    // 수정
    @Test
    @Order(4)
    @Rollback(value = false)
    void update(){

        BoardEntity boardEntity = boardRepository.findById(1L).get();

        boardEntity.setBoardTitle("글제목수정1");

        BoardEntity boardUpdate = boardRepository.save(boardEntity);

        Assertions.assertThat(boardUpdate.getBoardTitle()).isEqualTo("글제목수정1");
    }

    // 삭제
    @Test
    @Order(5)
    @Rollback(value = false)
    void delete() {

        BoardEntity boardEntity = boardRepository.findById(1L).get();

        boardRepository.delete(boardEntity);

        BoardEntity board1 = null;
        Optional<BoardEntity> optionalBoard = boardRepository.findByBoardTitle("글제목수정1");

        if (optionalBoard.isPresent()){
            board1 = optionalBoard.get();
        }

        Assertions.assertThat(board1).isNull();

    }

}