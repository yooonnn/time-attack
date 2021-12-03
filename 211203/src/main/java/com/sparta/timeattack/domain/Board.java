package com.sparta.timeattack.domain;

import com.sparta.timeattack.dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "Board")
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @OneToMany(mappedBy = "board")
//    private List<Comment> comments = new ArrayList<>();
    private List<Comment> comments;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public Board(String title, String content, String comment) {
//        this.title = title;
//        this.content = content;
//    }

    public Board(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }

    @Builder
    public Board(Long idx, String title, String content, String filePath) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }

}
