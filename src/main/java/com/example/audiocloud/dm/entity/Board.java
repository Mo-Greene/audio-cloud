package com.example.audiocloud.dm.entity;

import com.example.audiocloud.dm.vo.BoardVo;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Board(BoardVo boardVo) {
        this.title = boardVo.getTitle();
        this.content = boardVo.getContent();
    }
}
