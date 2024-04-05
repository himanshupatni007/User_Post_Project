package com.codewithhimanshu.blog.controller;

import com.codewithhimanshu.blog.payload.ApiResponse;
import com.codewithhimanshu.blog.payload.UserDTO;
import com.codewithhimanshu.blog.payload.UserResponse;
import com.codewithhimanshu.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO user = this.userService.createUser(userDTO);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("userId") Integer userId) {
        UserDTO userDTO1 = this.userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }

        @DeleteMapping("/{userId}")
        public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
            this.userService.deleteUser(userId);
         return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
        }

        @GetMapping("/{userId}")
        public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId){
            UserDTO userDTO1 = this.userService.getUserById(userId);
            return new ResponseEntity<>(userDTO1,HttpStatus.OK);
        }

        @GetMapping("/")
        public ResponseEntity<UserResponse> getAllUsers(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                        @RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize,
                                                        @RequestParam(value = "sortBy",defaultValue = "id",required = false ) String sortBy)
        {
        return  new ResponseEntity<>(this.userService.getAllUser(pageNumber,pageSize,sortBy),HttpStatus.OK);
        }


}
