package com.codewithhimanshu.blog.repositories;

import com.codewithhimanshu.blog.entities.Category;
import com.codewithhimanshu.blog.entities.Post;
import com.codewithhimanshu.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByCategory(Category categoryId);
    List<Post> findByUser(User userId);
}
