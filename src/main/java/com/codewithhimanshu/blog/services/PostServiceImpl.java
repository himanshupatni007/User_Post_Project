package com.codewithhimanshu.blog.services;

import com.codewithhimanshu.blog.entities.Category;
import com.codewithhimanshu.blog.entities.Post;
import com.codewithhimanshu.blog.entities.User;
import com.codewithhimanshu.blog.exceptions.ResourceNotFoundException;
import com.codewithhimanshu.blog.payload.PostDTO;
import com.codewithhimanshu.blog.repositories.CategoryRepo;
import com.codewithhimanshu.blog.repositories.PostRepo;
import com.codewithhimanshu.blog.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
  private  PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Not found", "userId", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Not found", "category", categoryId));
        Post map = this.modelMapper.map(postDTO, Post.class);
        map.setAddedDate(new Date());
        map.setImageName("default.png");
        map.setCategory(category);
        map.setUser(user);

        Post save = this.postRepo.save(map);
        return this.modelMapper.map(save,PostDTO.class);

    }

    @Override
    public Post updatePost(PostDTO postDTO, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPost(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Not found", "category", categoryId));
        List<Post> byCategory = this.postRepo.findByCategory(category);
        List<PostDTO> collect = byCategory.stream().map(Post -> this.modelMapper.map(Post, PostDTO.class)).collect(Collectors.toList());
       return collect;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Not found", "userId", userId));
        List<Post> byUser = this.postRepo.findByUser(user);
        List<PostDTO> collect = byUser.stream().map(Post -> this.modelMapper.map(Post, PostDTO.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
