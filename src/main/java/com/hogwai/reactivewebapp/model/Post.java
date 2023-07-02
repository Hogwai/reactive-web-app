package com.hogwai.reactivewebapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publishedAt;
    private String author;
    private int likes;
}
