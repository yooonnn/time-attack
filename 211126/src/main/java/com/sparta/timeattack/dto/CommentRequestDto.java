package com.sparta.timeattack.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class CommentRequestDto {
    private final Long idx;
    private final String comment;
}
