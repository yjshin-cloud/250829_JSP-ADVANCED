package com.example.jpaadv.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이걸 상속하는 엔티티에 추상필드들을 컬럼으로 포함
@EntityListeners(AuditingEntityListener.class) // Audit 감사 (createdAt, updatedAt...)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}