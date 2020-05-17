package com.lavamancer.workshop.rest;

import com.lavamancer.workshop.model.Post;
import com.lavamancer.workshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PostRest {

    @Autowired PostService postService;


    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> getRestTemplatePosts(
            @RequestParam(required = false, defaultValue = "true") Boolean retrofit
    ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPosts(retrofit));
    }

    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Post> getRestTemplatePost(
            @PathVariable Long postId,
            @RequestParam(required = false, defaultValue = "true") Boolean retrofit
    ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPost(retrofit, postId));
    }

}
