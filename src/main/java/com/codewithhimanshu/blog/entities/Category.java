package com.codewithhimanshu.blog.entities;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
   @Name("Title")
    private String categoryTitle;
    @Name("Description")
    private String categoryDescription;

 @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> posts= new ArrayList<>();
}
