package com.sparta.timeattack.controller;

import com.sparta.timeattack.domain.Board;
import com.sparta.timeattack.dto.BoardRequestDto;
import com.sparta.timeattack.dto.CommentRequestDto;
import com.sparta.timeattack.dto.TagRequestDto;
import com.sparta.timeattack.repository.BoardRepository;
import com.sparta.timeattack.repository.CommentRepository;
import com.sparta.timeattack.service.BoardService;
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


    @PostMapping("/article")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        System.out.println(requestDto.getTitle());
        System.out.println(requestDto.getContent());
        System.out.println(requestDto.getTag());

        Board board = new Board(requestDto);
        System.out.println(board);
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

//    @PostMapping("/article")
//    public void createTag(@RequestBody TagRequestDto tagRequestDto) {
//        boardService.createTag(tagRequestDto);
//    }

//    @GetMapping("/view/{idx}/getComments")
//    public List<Comment> getComment(@PathVariable Board Idx) {
//        return boardService.getComment();
//    }



}
