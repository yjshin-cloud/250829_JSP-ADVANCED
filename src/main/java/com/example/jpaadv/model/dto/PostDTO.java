package com.example.jpaadv.model.dto;

import com.example.jpaadv.model.entity.Post;
import lombok.Data;
import java.time.LocalDateTime;

// Form - jsp(el). thymeleaf(object) -> getter, setter
public class PostDTO {
    // nested class
    // form 요청을 받기 위한 class
//    @Getter
//    @Setter
//    @NoArgsConstructor
    @Data
    public static class SaveRequest {
        private String title; // ID, audit(CreatedAt, UpdatedAt...)
        private String content;
        private String author;

        // DTO -> Entity
        public Post toEntity() {
            return Post.builder()
                    .author(author)
                    .content(content)
                    .title(title) // 순서가 꼭 고정적인 필요가 없는...
                    .build();
        }
    }
    // 외부로 데이터가 나가기 위한 class -> Record.
    /*
        private final Long id;
        private final String title;
        private final String content;
        private final String author;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        // Entity → DTO 변환
        public Response(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.author = post.getAuthor();
            this.createdAt = post.getCreatedAt();
            this.updatedAt = post.getUpdatedAt();
        }
     */
    public record Response(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        // static -> Response를 만들지 않아도 변환해서 쓸 수 있게.
        public static Response fromEntity(Post post) {
            return new Response(
                    post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getAuthor(),
                    post.getCreatedAt(),
                    post.getUpdatedAt()
            );
        }
    }
}