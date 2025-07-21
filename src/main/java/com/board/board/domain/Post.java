package com.board.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "TBL_POST")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Post extends BaseEntity{

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
