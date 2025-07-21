package com.board.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@SQLRestriction("delete_flag = false")
//@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SoftDelete
    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "modified_by", nullable = false)
    private String modifiedBy;

    @Column(name = "modified_date", nullable = false)
    private LocalDateTime modifiedDate;

    @PrePersist
    public void onPrePersist() {
        // createdDate는 @CreatedDate가 자동으로 채움
        if (this.modifiedDate == null) {
            this.modifiedDate = this.createdDate != null ? this.createdDate : LocalDateTime.now();
        }
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }
}