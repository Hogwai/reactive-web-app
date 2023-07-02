package com.hogwai.reactivewebapp.record;

import com.hogwai.reactivewebapp.model.Post;

import java.time.LocalDateTime;

public record PostRecord(String title, String content, LocalDateTime publishedAt, String author, int likes) {
    public static PostRecord fromPost(Post post) {
        return new PostRecord(post.getTitle(), post.getContent(), post.getPublishedAt(), post.getAuthor(), post.getLikes());
    }

    public Post toPost() {
        Post post = new Post();
        post.setTitle(title());
        post.setContent(content());
        post.setAuthor(author());
        post.setLikes(likes());
        post.setPublishedAt(publishedAt());
        return post;
    }
}
