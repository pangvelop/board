package com.board.board.controller;

import com.board.board.domain.Post;
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
    public List<Post> lists() {
        return postService.getPosts();
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public Post list(@PathVariable Long id) {
        return postService.getPost(id);
    }

}
