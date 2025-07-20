package com.board.board.service;

import com.board.board.domain.Post;
import com.board.board.domain.request.PostRequestDto;
import com.board.board.domain.response.PostResponseDto;
import com.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    public List<PostRequestDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostRequestDto::new)
                .toList();
    }

    public PostRequestDto getPost(Long id) {
        return postRepository.findById(id)
                .map(PostRequestDto::new)
                .orElseThrow(() -> new RuntimeException("There is no post"));
    }
    @Transactional
    public PostResponseDto createPost(PostRequestDto dto) {
        Post post = new Post(
                dto.getTitle(),
                dto.getContent()
        );

        Post savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost);
    }

//    public Post updatePost(Long id, Post newPost) {
//
//        Post post = getPost(id);
//        return postRepository.save(post);
//    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
