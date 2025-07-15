package com.board.board.controller;

import com.board.board.domain.Post;
import com.board.board.domain.request.PostRequestDto;
import com.board.board.domain.response.PostResponseDto;
import com.board.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    // 게시글 다건 조회
    // DTO로 바꾸자
    @GetMapping
    public List<Post> list() {
        return postService.getPosts();
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public Post detail(@PathVariable Long id) {
        return postService.getPost(id);
    }

}
