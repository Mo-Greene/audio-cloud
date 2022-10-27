package com.example.audiocloud.controller;

import com.example.audiocloud.dm.vo.BoardVo;
import com.example.audiocloud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 게시글 post 화면
    @GetMapping("/create")
    public String boardCreate() {
        return "board/board-write";
    }

    // 게시글 posting
    @PostMapping("/write")
    public String boardPost(BoardVo boardVo) {
        boardService.boardCreate(boardVo);
        return "redirect:/board";
    }

    // 게시글 전체 조회
    @GetMapping("")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "board/board-list";
    }

    // 게시글 상세 조회
    @GetMapping("/detail")
    public String boardDetailView(Model model, Long boardSeq) {

        model.addAttribute("view", boardService.boardDetailView(boardSeq));

        return "board/board-view";
    }

    // 게시글 detail delete
    @GetMapping("/delete")
    public String deleteBoardView(Long boardSeq) {
        boardService.deleteBoardById(boardSeq);
        return "redirect:/board";
    }
}
