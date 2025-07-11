package com.board.board.domain;

import com.board.board.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "TBL_MEMBER")
public class Member extends BaseEntity{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}