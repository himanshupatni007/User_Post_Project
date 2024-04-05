package com.codewithhimanshu.blog.services;

import com.codewithhimanshu.blog.entities.User;
import com.codewithhimanshu.blog.payload.UserDTO;
import com.codewithhimanshu.blog.payload.UserResponse;

import java.util.List;

public interface UserService {


    UserDTO createUser(UserDTO user);
      UserDTO  updateUser(UserDTO userDTO,Integer userId);

      UserDTO  getUserById(Integer userId);
      UserResponse getAllUser(Integer pageNumber, Integer pageSize,String sortBy);

      void deleteUser(Integer UserId);
}
