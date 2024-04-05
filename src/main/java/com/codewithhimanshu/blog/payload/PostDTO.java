package com.codewithhimanshu.blog.payload;

import com.codewithhimanshu.blog.entities.Category;
import com.codewithhimanshu.blog.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {



    private String title;

    private String content;

    private String imageName;
    private Date addedDate;


    private CategoryDTO category;


    private UserDTO user;


}
