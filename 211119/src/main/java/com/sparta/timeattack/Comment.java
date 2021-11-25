package com.sparta.timeattack;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name="board_idx", nullable = false)
    private Board board;

//    public Comment(String comment, Board board) {
//        this.comment= comment;
//        this.board = board;
//    }

    public Comment(CommentRequestDto requestDto) {
        this.comment= requestDto.getComment();
        this.board = board;
    }

    @Builder
    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(CommentRequestDto commentRequestDto, Board board) {
        this.comment = commentRequestDto.getComment();
        this.board = board;
    }

//    public Comment(CommentRequestDto requestDto) {
//        super();
//    }
}
