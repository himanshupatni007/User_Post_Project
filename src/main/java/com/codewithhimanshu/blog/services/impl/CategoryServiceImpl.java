package com.codewithhimanshu.blog.services.impl;

import com.codewithhimanshu.blog.entities.Category;
import com.codewithhimanshu.blog.exceptions.ResourceNotFoundException;
import com.codewithhimanshu.blog.payload.CategoryDTO;
import com.codewithhimanshu.blog.repositories.CategoryRepo;
import com.codewithhimanshu.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category map = this.modelMapper.map(categoryDTO, Category.class);
        Category save = this.categoryRepo.save(map);
        return this.modelMapper.map(save,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryID) {
        Category category = this.categoryRepo.findById(categoryID).orElseThrow(() -> new ResourceNotFoundException("Not found", "category", categoryID));
         category.setCategoryDescription(categoryDTO.getCategoryDescription());
         category.setCategoryTitle(categoryDTO.getCategoryTitle());
        Category save = this.categoryRepo.save(category);
        return this.modelMapper.map(save,CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Not found", "category", categoryId));
         this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Not found", "category", categoryId));
          return this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> all = this.categoryRepo.findAll();
        List<CategoryDTO> collect = all.stream().map(category -> this.modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
        return  collect;
    }
}
