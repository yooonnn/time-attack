package com.sparta.timeattack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;
    private final BoardService boardService;


    @GetMapping("/boards")
    public List<Board> getBoards() {
//        List<Board> board = new BoardRepository().findAll();
//        List<Board> boardRepository.findAll(); = new board;
        return boardRepository.findAll();
    }


    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
}
