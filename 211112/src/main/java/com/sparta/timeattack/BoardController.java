package com.sparta.timeattack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;
    private final BoardService boardService;
//
//    public BoardController() {
//    }

    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }


    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {

        Board board = new Board(requestDto);

        return boardRepository.save(board);
    }
}
