package com.vtnlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public class GovMapper {
    public static UserPostDTO map(User user, List<Post> posts){
        List<PostDTO> postDTOs = posts.stream()
                                    .filter(e -> e.getUserId() == user.getId())
                                    .map(e->{
                                        return PostDTO.builder()
                                            .id(e.getId())
                                            .title(e.getTitle())
                                            .body(e.getBody())
                                            .build();
                                    }).collect(Collectors.toList());
        return UserPostDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .phone(user.getPhone())
            .postDTOs(postDTOs)
            .build();
        }

    public static UserCommentDTO mapComment(User user, List<Comment> comments){
        List<CommentDTO> commentDTOs = comments.stream()
                                    .filter(e -> e.getPostId() == user.getId())
                                    .map(e->{
                                        return CommentDTO.builder()
                                            .id(e.getId())
                                            .name(e.getName())
                                            .email(e.getEmail())
                                            .body(e.getBody())
                                            .build();
                                    }).collect(Collectors.toList());
        // List<CommentDTO> commentDTOs = 
        return UserCommentDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .phone(user.getPhone())
            .commentDTOs(commentDTOs)
            .build();
        }

    
}
