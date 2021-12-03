package com.sparta.timeattack.controller;

import com.sparta.timeattack.domain.Board;
import com.sparta.timeattack.dto.BoardRequestDto;
import com.sparta.timeattack.dto.CommentRequestDto;
import com.sparta.timeattack.repository.BoardRepository;
import com.sparta.timeattack.repository.CommentRepository;
import com.sparta.timeattack.service.BoardService;
import com.sparta.timeattack.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final CommentRepository commentRepository;
    private final S3Service s3Service;


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
    public void createBoard(MultipartFile file, BoardRequestDto boardRequestDto) throws IOException {
        String imgPath = s3Service.upload(file);
        System.out.println("file:::" + file);
        System.out.println("dto:::" + boardRequestDto);
        boardRequestDto.setFilePath(imgPath);
        boardService.createBoard(boardRequestDto);
    }

    @PostMapping("/view/comment")
    public void createComment(@RequestBody CommentRequestDto commentRequestDto) {
        boardService.createComment(commentRequestDto);
    }



}
