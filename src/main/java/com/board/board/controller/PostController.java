package com.board.board.controller;

import com.board.board.domain.Post;
import com.board.board.domain.request.PostRequestDto;
import com.board.board.domain.response.PostResponseDto;
import com.board.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    // 게시글 다건 조회
    // DTO로 바꾸자
    @GetMapping
    public List<PostRequestDto> lists() {
        return postService.getPosts();
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public PostRequestDto list(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping
    public PostResponseDto create(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.updatePost(id,requestDto);
    }

}
