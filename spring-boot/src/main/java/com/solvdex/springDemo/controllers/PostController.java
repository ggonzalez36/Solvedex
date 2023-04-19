package com.solvdex.springDemo.controllers;


import com.solvdex.springDemo.models.Post;
import com.solvdex.springDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8081" , maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Post> getPost(@PathVariable Long id){

        Optional<Post> post = postService.getById(id);

        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Post> createPost(@RequestBody Post post){

        Post createdPost = postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);

    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){

        Post createdPost = postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> createPost(@PathVariable Long id){

         postService.delete(id);
        return ResponseEntity.noContent().build();

    }



}
