package com.codewithhimanshu.blog.repositories;

import com.codewithhimanshu.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
