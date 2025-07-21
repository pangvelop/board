package com.board.board.domain.response;

import com.board.board.domain.Post;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto {
    private String title;
    private String content;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
