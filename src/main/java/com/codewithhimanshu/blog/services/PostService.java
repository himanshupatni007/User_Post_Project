package com.codewithhimanshu.blog.services;

import com.codewithhimanshu.blog.entities.Post;
import com.codewithhimanshu.blog.payload.PostDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {


    PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId);

    Post updatePost(PostDTO postDTO,Integer postId);

    void deletePost(Integer postId);

    Post getPost(Integer postId);

    List<Post> getAllPost();

    List<PostDTO>   getPostByCategory(Integer categoryId);

    List<PostDTO>   getPostByUser(Integer userId);

    List<Post> searchPost(String keyword);
}
