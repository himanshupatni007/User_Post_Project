package com.codewithhimanshu.blog.controller;


import com.codewithhimanshu.blog.entities.Post;
import com.codewithhimanshu.blog.payload.PostDTO;
import com.codewithhimanshu.blog.services.CategoryService;
import com.codewithhimanshu.blog.services.PostService;
import com.codewithhimanshu.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    PostService postService;


    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDTO post = this.postService.createPost(postDTO, userId, categoryId);
      return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId){
        List<PostDTO> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(postByUser,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>>  getPostByCategory(@PathVariable Integer categoryId){
        List<PostDTO> postByCategory = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);
        }
}
