package com.sparta.timeattack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class BoardRequestDto {
    private final String title;
    private final String content;

}
