package com.codewithhimanshu.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

     private String title;

     private String content;

     private String imageName;
     private Date addedDate;

     @ManyToOne
     @JoinColumn(name = "catagory_id")
     private Category category;

     @ManyToOne
     private User user;


}
