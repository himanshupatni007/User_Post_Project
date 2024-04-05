package com.codewithhimanshu.blog.services;

import com.codewithhimanshu.blog.entities.Category;
import com.codewithhimanshu.blog.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO  updateCategory(CategoryDTO categoryDTO, Integer categoryID);

    void deleteCategory(Integer categoryId);

    CategoryDTO getCategory(Integer categoryId);

    List<CategoryDTO> getAllCategories ();

}
