package com.sparta.timeattack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final CommentRepository commentRepository;


    @GetMapping("/boards")
    public List<Board> getBoards() {
//        List<Board> board = new BoardRepository().findAll();
//        List<Board> boardRepository.findAll(); = new board;
        return boardRepository.findAll();
    }

    @GetMapping("/view/{idx}")
    public Board viewBoard(@PathVariable Long idx) {
//        boardRepository.findById(id);
        return boardRepository.findById(idx).orElseThrow(
                () -> new IllegalArgumentException("없음")
        );
    }


    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

//    @PostMapping("/view/comment")
//    public void createComment(@RequestBody CommentRequestDto requestDto) {
////        System.out.println(requestDto.getIdx());
////
////        Comment comment = new Comment(requestDto);
////        return commentRepository.save(comment);
//        boardService.setComment(requestDto);
//    }

    @PostMapping("/view/comment")
    public void createComment(@RequestBody CommentRequestDto commentRequestDto) {
        boardService.createComment(commentRequestDto);
    }

//    @GetMapping("/view/{idx}/getComments")
//    public List<Comment> getComment(@PathVariable Board Idx) {
//        return boardService.getComment();
//    }



}
