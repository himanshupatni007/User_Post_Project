package com.codewithhimanshu.blog.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JWTRequest {

    private String email;
    private String password;
}
