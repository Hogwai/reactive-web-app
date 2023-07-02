package com.hogwai.reactivewebapp.service;

import com.hogwai.reactivewebapp.model.Post;
import com.hogwai.reactivewebapp.record.PostRecord;
import com.hogwai.reactivewebapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Flux<Post> findAll() {
        return postRepository.findAll();
    }

    public Mono<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Mono<Post> save(PostRecord postRecord) {
        Post postToSave = postRecord.toPost();
        postToSave.setPublishedAt(LocalDateTime.now());
        return postRepository.save(postToSave);
    }

    public Mono<Post> update(Long id, PostRecord postRecord) {
        return postRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPost -> {
                    if (optionalPost.isPresent()) {
                        Post postToUpdate = postRecord.toPost();
                        postToUpdate.setId(id);
                        return postRepository.save(postToUpdate);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(Long id) {
        return postRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return postRepository.deleteAll();
    }
}
