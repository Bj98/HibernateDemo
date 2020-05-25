package com.example.HibernateDemo.controllers;

import com.example.HibernateDemo.models.Post;
import com.example.HibernateDemo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/post/{id}")
    public Optional<Post> getPostById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @GetMapping("/posts/user/{id}")
    public List<Post> getPostsByUserId(@PathVariable Integer id){
        return postService.getPostsByUserId(id);

    }

    @PostMapping("/post/addNew")
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @PutMapping("/post/{id}/update")
    public void updatePost(@RequestBody Post post){
        postService.updatePost(post);
    }

    @DeleteMapping("/post/{id}/delete")
    public  void deletePost(@PathVariable Integer id){
        postService.deletePost(id);
    }

}
