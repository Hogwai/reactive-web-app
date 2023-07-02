package com.hogwai.reactivewebapp.controller;

import com.hogwai.reactivewebapp.model.Post;
import com.hogwai.reactivewebapp.record.PostRecord;
import com.hogwai.reactivewebapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Flux<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Post> createPost(@RequestBody PostRecord post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public Mono<Post> updatePost(@PathVariable Long id, @RequestBody PostRecord post) {
        return postService.update(id, post)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found")));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePost(@PathVariable Long id) {
        return postService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllPosts() {
        return postService.deleteAll();
    }
}
