package com.sparta.timeattack;

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
