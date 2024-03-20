package com.vtnlab.bootcamp.bootcampsbforum.controller.impl;

// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtnlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtnlab.bootcamp.bootcampsbforum.mapper.GovMapper;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;
@RestController
@RequestMapping(value="/gov/api/v1")
public class GovController implements GovOperation {

    @Autowired
    private GovService govService;

    @Autowired
    private UserService userService;

    @Autowired
    private GovMapper govMapper;

    // userservice
    // postservice
    // relate user and post
    // set DTO object

    @Override
    public ApiResp<List<UserPostDTO>> getUsers() {
        List<UserPostDTO> userPostDtos = govService.getUsers().stream() // call JPH + save DB
            .map(e -> {
            List<PostDTO> postDTOs = userService.getPosts().stream() //
                .filter(p -> p.getUserId() == e.getId()) //
                .map(p -> {
                    return PostDTO.builder() //
                        .id(p.getId()) //
                        .title(p.getTitle()) //
                        .body(p.getBody()).build();
                }).collect(Collectors.toList());

            return UserPostDTO.builder() //
                .id(e.getId()) //
                .username(e.getUsername()) //
                .email(e.getEmail()) //
                .phone(e.getPhone()) //
                .postDTOs(postDTOs) //
                .build();
            }).collect(Collectors.toList());

        return ApiResp.<List<UserPostDTO>>builder() //
            .code(Syscode.OK.getCode()) //
            .message(Syscode.OK.getMessage()) //
            .data(userPostDtos) //
            .build();
    }

    @Override
    public ApiResp<UserPostDTO> getUser(int userId){
    
        
        User user=govService.getUser(userId);
        List<PostDTO> postDTOs=userService.getPosts().stream()
                                .filter(e->e.getUserId()==userId)
                                .map(e->{
                                    return PostDTO.builder()
                                    .id(e.getId())
                                    .title(e.getTitle())
                                    .body(e.getBody()).build();
                                }).collect(Collectors.toList());
        UserPostDTO userPostDTO=UserPostDTO.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .phone(user.getPhone())
                                .postDTOs(postDTOs).build();
        return ApiResp.<UserPostDTO>builder().code(Syscode.OK.getCode())
                            .message(Syscode.OK.getMessage())
                            .data(userPostDTO)
                            .build();
    }

    @Override
    public ApiResp<UserCommentDTO>  getUserComment(int userId) {
       
        return null;

    }

    // GlobalExceptionHandler -> NPE
    @Override
    public String testNPE() {
        String s=null;
        return s.concat("hello");
    }

    @Override
    public UserDTO testModelMapper() {
        User user = User.builder().id(3).email("an@gmail.com").phone("54646").username("jojojo").name("jojo").build();
        return govMapper.map(user);
    }

    
}
