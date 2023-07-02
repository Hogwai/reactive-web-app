package com.hogwai.reactivewebapp.repository;

import com.hogwai.reactivewebapp.model.Post;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PostRepository extends R2dbcRepository<Post, Long> {
}