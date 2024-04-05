package com.codewithhimanshu.blog.repositories;

import com.codewithhimanshu.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
