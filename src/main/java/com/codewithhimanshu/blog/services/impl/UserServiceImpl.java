package com.codewithhimanshu.blog.services.impl;

import com.codewithhimanshu.blog.entities.User;
import com.codewithhimanshu.blog.exceptions.ResourceNotFoundException;
import com.codewithhimanshu.blog.payload.UserDTO;
import com.codewithhimanshu.blog.payload.UserResponse;
import com.codewithhimanshu.blog.repositories.UserRepo;
import com.codewithhimanshu.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO user) {
      User  save = this.DTOTOUser(user);
          User savedUser= this.userRepo.save(save);
          return this.entityToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());
      User updatedUser=  this.userRepo.save(user);
      return this.entityToDTO(updatedUser);

    }

    @Override
    public UserDTO getUserById(Integer userId) {
       User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));

      return this.entityToDTO(user);
    }

    @Override
    public UserResponse getAllUser(Integer pageNumber, Integer pageSize,String sortBy) {
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy).ascending());
        Page<User> all1 = this.userRepo.findAll(pageRequest);
        List<User> all = all1.getContent();
        List<UserDTO> collect = all.stream().map(user -> this.entityToDTO(user)).collect(Collectors.toList());
       UserResponse userResponse = new UserResponse();
       userResponse.setContent(collect);
       userResponse.setPageNumber(all1.getNumber());
       userResponse.setPageSize(all1.getSize());
       userResponse.setTotalElements(all1.getTotalElements());
       userResponse.setTotalPages(all1.getTotalPages());
       userResponse.setLastPage(all1.isLast());
       return userResponse;
    }

    @Override
    public void deleteUser(Integer UserId) {
        User user = this.userRepo.findById(UserId).orElseThrow(() -> new ResourceNotFoundException("user", "id", UserId));
           this.userRepo.delete(user);
    }

    public User DTOTOUser(UserDTO user)
    {
         User user1 = this.modelMapper.map(user,User.class);

//         User user1 = new User();
//         user1.setId(user.getId());
//         user1.setAbout(user.getAbout());
//         user1.setName(user.getName());
//         user1.setEmail(user.getEmail());
//         user1.setPassword(user.getPassword());
         return  user1;

    }

    public UserDTO  entityToDTO(User user){
        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setAbout(user.getAbout());
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
