package com.codewithhimanshu.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserResponse {

    private List<UserDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private Boolean lastPage;
}
