package com.sparta.timeattack.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TagRequestDto {
    private final Long idx;
    private final String tag;
}
