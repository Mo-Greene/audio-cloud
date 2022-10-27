package com.example.audiocloud.dm.dto;

import com.example.audiocloud.dm.entity.Board;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {

    private Long boardSeq;
    private String title;
    private String content;

    public BoardDto(Board board) {
        this.boardSeq = board.getBoardSeq();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
