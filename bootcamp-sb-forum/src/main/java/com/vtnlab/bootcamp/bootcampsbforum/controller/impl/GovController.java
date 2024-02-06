package com.vtnlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtnlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;
@RestController
@RequestMapping(value="gov/api/v1")
public class GovController implements GovOperation {
    @Autowired
    private UserService userService;

    // userservice
    // postservice
    // relate user and post
    // set DTO object

    @Override
    public ApiResp<UserPostDTO> getUser(int userId){
    
        // Optional<UserPostDTO> userPostDTO = userService.getUsers().stream()
        //                                     .filter(e->e.getId()==userId)
        //                                     .map(e->{
        //                                         List<Post> posts=userService.getPosts();
        //                                         return GovMapper.map(e, posts);
        //                                     })
        //                                     .findFirst();

        // if (userPostDTO.isPresent()) {
        //     ApiResp<UserPostDTO> apiResp = ApiResp.<UserPostDTO>builder()
        //                                         .code(Syscode.OK.getCode())
        //                                         .message(Syscode.OK.getMessage())
        //                                         .data(userPostDTO.get())
        //                                         .build();
        //     return ResponseEntity.ok(apiResp);
        // }

        // ApiResp<UserPostDTO> apiResp1 = ApiResp.<UserPostDTO>builder()
        //                                 .code(Syscode.NOTFOUND.getCode())
        //                                 .message(Syscode.NOTFOUND.getMessage())
        //                                 // .data()
        //                                 .build();
        // // throw new ResourceNotFound(Syscode.NOTFOUND);
        // // return ResponseEntity.noContent().build();
        // return ResponseEntity.ok(apiResp1);
        User user = userService.getUser(userId);
        List<PostDTO> postDTOs = userService.getPosts().stream()
                                    .filter(e->e.getId()==userId)
                                    .map(e->{
                                        return PostDTO.builder()
                                            .id(e.getId())
                                            .title(e.getTitle())
                                            .body(e.getBody()).build();
                                    }).collect(Collectors.toList());

        UserPostDTO userPostDTO = UserPostDTO.builder()
                                    .id(user.getId()).username(user.getUsername())
                                    .email(user.getEmail())
                                    .phone(user.getPhone())
                                    .postDTOs(postDTOs).build();
           
        return ApiResp.<UserPostDTO>builder()
                .code(Syscode.OK.getCode())
                .message(Syscode.OK.getMessage())
                .data(userPostDTO)
                .build();
    }

    // @Override
    // public ResponseEntity<ApiResp<UserCommentDTO>>  getUserComment(int userId) {
    //     Optional<UserCommentDTO> userCommentDTO = userService.getUsers().stream()
    //                                         .filter(e->e.getId()==userId)
    //                                         .map(e->{
    //                                             List<Comment> comments=userService.getComments();
    //                                             return GovMapper.mapComment(e, comments);
    //                                         })
    //                                         .findFirst()
    //                                         ;

    //     if (userCommentDTO.isPresent()) {
    //         ApiResp<UserCommentDTO> apiResp = ApiResp.<UserCommentDTO>builder()
    //                                             .code(Syscode.OK.getCode())
    //                                             .message(Syscode.OK.getMessage())
    //                                             .data(userCommentDTO.get())
    //                                             .build();
    //         return ResponseEntity.ok(apiResp);
    //     }

    //     ApiResp<UserCommentDTO> apiResp2 = ApiResp.<UserCommentDTO>builder()
    //                                     .code(Syscode.NOTFOUND.getCode())
    //                                     .message(Syscode.NOTFOUND.getMessage())
    //                                     // .data()
    //                                     .build();
    //     // throw new ResourceNotFound(Syscode.NOTFOUND);
    //     // return ResponseEntity.noContent().build();
    //     return ResponseEntity.ok(apiResp2);
    // }

    // GlobalExceptionHandler -> NPE
    @Override
    public String testNPE() {
        String s=null;
        return s.concat("hello");
    }

    
}
