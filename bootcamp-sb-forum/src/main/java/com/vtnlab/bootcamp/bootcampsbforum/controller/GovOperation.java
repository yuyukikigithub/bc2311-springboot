package com.vtnlab.bootcamp.bootcampsbforum.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;

public interface GovOperation {

    // no user found
    // user found but no post(empty Array of post)
    @GetMapping(value="/users")
     ApiResp<List<UserPostDTO>> getUsers() ;

    @GetMapping(value="/user/{userId}")
    // UserPostDTO getUser(@PathVariable int userId) throws ResourceNotFound;
    ApiResp<UserPostDTO> getUser(@PathVariable int userId) ;
    // ResponseEntity<UserPostDTO>(@PathVariable int userId);

    // no user found
    // user found but no comment (empty Array of comment)
    @GetMapping(value="/comments")
    ApiResp<UserCommentDTO> getUserComment(@RequestParam int userId);

    @GetMapping(value="/test")
    String testNPE();

    @GetMapping(value="/test/modelmapper")
    UserDTO testModelMapper();
    
} 