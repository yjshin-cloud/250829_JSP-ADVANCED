package com.example.jpaadv.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL
    private Long id;

    @Column(length = 500, nullable = false) // not null, 500.
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false) // not null
    private String content;
    @Column(length = 100)
    private String author;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // entity의 경우 setter 사용 지양을 위한 update.
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}