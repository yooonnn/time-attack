package com.sparta.timeattack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoardRequestDto {
    private String content;

    public BoardRequestDto(String content) {
        this.content = content;
    }
}
