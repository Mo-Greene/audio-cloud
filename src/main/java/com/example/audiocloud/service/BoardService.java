package com.example.audiocloud.service;

import com.example.audiocloud.dm.dto.BoardDto;
import com.example.audiocloud.dm.entity.Board;
import com.example.audiocloud.dm.vo.BoardVo;
import com.example.audiocloud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 posting
    public void boardCreate(BoardVo boardVo) {
        Board board = new Board(boardVo);
        boardRepository.save(board);
    }

    // 게시글 전체 조회
    public List<BoardDto> boardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for (Board board : boards) {
            BoardDto boardDto = new BoardDto(
                    board.getBoardSeq(),
                    board.getTitle(),
                    board.getContent()
            );
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    // 게시글 상세 조회
    public BoardDto boardDetailView(Long boardSeq) {
        Board board = boardRepository.findById(boardSeq).orElseThrow(
                () -> new NullPointerException("게시물이 없습니다.")
        );
        return new BoardDto(board);
    }

    // 게시글 삭제
    public void deleteBoardById(Long boardSeq) {
        boardRepository.deleteById(boardSeq);
    }

}
