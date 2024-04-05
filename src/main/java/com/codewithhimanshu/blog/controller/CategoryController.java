package com.codewithhimanshu.blog.controller;


import com.codewithhimanshu.blog.payload.CategoryDTO;
import com.codewithhimanshu.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategories(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO category = this.categoryService.createCategory(categoryDTO);
       return  new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer category_id){
        CategoryDTO category = this.categoryService.getCategory(category_id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable Integer category_id){
        CategoryDTO categoryDTO1 = this.categoryService.updateCategory(categoryDTO, category_id);
       return new ResponseEntity<>(categoryDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/{category_id}")
    public void deleteCategory(@PathVariable Integer category_id){
        this.categoryService.deleteCategory(category_id);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getall(){
        List<CategoryDTO> allCategories = this.categoryService.getAllCategories();
       return new ResponseEntity<>(allCategories,HttpStatus.OK);
    }

}
