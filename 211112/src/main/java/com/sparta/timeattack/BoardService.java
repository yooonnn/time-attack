package com.sparta.timeattack;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


//    List<Board> boardList = boardRepository.findAll();
//    for (int i = 0; i < boardList.size(); i++) {
//        Board board = boardList.get(i);
//        System.out.println(board.getId());
//        System.out.println(board.getContent());
//    }

//    Board board = boardRepository.findById(1L).orElseThrow(
//            () -> new IllegalArgumentException("None")
//    );
}
