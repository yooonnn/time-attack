package com.sparta.timeattack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.timeattack.dto.TagRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tag extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @JsonIgnore // 이게 무한루프에 빠지는 걸 방지해줌
    @ManyToOne
    @JoinColumn(name="board_idx", nullable = false)
    private Board board;


    public Tag(TagRequestDto tagRequestDto, Board board) {
        this.tag = tagRequestDto.getTag();
        this.board = board;
    }
}
