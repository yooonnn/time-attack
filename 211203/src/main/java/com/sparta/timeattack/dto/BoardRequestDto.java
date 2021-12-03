package com.sparta.timeattack.dto;

import com.sparta.timeattack.domain.Board;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class BoardRequestDto {
    private Long idx;
    private String title;
    private String content;
    private String filePath;

    public Board toEntity() {
        Board build = Board.builder()
                .idx(idx)
                .title(title)
                .content(content)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public BoardRequestDto(Long idx, String title, String content, String filePath) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }

}
