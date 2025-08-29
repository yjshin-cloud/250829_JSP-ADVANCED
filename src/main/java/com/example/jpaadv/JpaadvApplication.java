package com.example.jpaadv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaadvApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaadvApplication.class, args);
    }

}