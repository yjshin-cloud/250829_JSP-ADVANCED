package com.example.jpaadv.model.repository;

import com.example.jpaadv.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // JPQL
    @Query("SELECT p FROM Post p ORDER BY p.id DESC") // ID 기준으로 내림차순
    List<Post> findAllDesc(); // JPQL
    // JOIN은 User -> Spring Security에 추가하고...

    // save, find all ... -> JPA -> 여러 키워드를 조합해서 메서드 들 만들어내는 기능
}