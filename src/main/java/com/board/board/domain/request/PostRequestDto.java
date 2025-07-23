package com.board.board.domain.request;

import com.board.board.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;

    public PostRequestDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
