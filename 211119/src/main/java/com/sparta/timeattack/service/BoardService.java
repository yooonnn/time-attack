package com.sparta.timeattack.service;

import com.sparta.timeattack.dto.CommentRequestDto;
import com.sparta.timeattack.domain.Board;
import com.sparta.timeattack.domain.Comment;
import com.sparta.timeattack.repository.BoardRepository;
import com.sparta.timeattack.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void createComment(CommentRequestDto commentRequestDto) {
        Board board = boardRepository.findById(commentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("없다고오오오")
        );

        Comment comment = new Comment(commentRequestDto, board);
        commentRepository.save(comment);

    }

//    @Transactional
//    public Comment createComment(CommentRequestDto requestDto, Board board){
//        Comment comment = Comment.builder()
//                .comment(requestDto.getComment())
//                .build();
//
//        boardRepository.findById(board.getIdx()).orElseThrow(
//                () -> new IllegalArgumentException("없다고오오오")
//        );
//        commentRepository.save(comment);
//        board.getComments().add(comment);
//        return comment;
//    }

    public List<Comment> getComment() {
        return commentRepository.findAll();
    }
}
