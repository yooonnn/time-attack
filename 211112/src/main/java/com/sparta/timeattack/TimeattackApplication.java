package com.sparta.timeattack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TimeattackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeattackApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository) {
        return (args) -> {
//            Board board = new Board("안녕");
//            boardRepository.save(board);
//            boardRepository.findAll();

            List<Board> boardList = boardRepository.findAll();
        };
    }



}
