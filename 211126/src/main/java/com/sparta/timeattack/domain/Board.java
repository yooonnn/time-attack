package com.sparta.timeattack.domain;

import com.sparta.timeattack.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "board")
//    private List<Comment> comments = new ArrayList<>();
    private List<Comment> comments;

    @OneToMany(mappedBy = "board")
//    private List<Comment> comments = new ArrayList<>();
    private List<Tag> tags;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board(Long idx, String title, List<Tag> tags) {
        this.idx = idx;
        this.title = title;
        this.tags = tags;
    }

    //    public Board(String title, String content, String comment) {
//        this.title = title;
//        this.content = content;
//    }

    public Board(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }

}
