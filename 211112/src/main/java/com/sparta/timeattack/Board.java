package com.sparta.timeattack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
public class Board {

    public Board() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    public Board(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return this.content;
    }

    public Board(String content) {
        this.content = content;
    }

}
