package com.vtnlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserDTO;
import com.vtnlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
// when server start Spring will ensure modelMapper is ready before creating GovMapper object
@Component
public class GovMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO map(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
    
    public com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity mapEntity(User user){
        return com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity.builder()
                .name(user.getName())
                .username(user.getUsername())
                .website(user.getWebsite())
                .addrLat(user.getAddress().getGeo().getLat())
                .addrLng(user.getAddress().getGeo().getLng())
                .email(user.getEmail())
                .phone(user.getPhone())
                .street(user.getAddress().getStreet())
                .city(user.getAddress().getCity())
                .suite(user.getAddress().getSuite())
                .zipcode(user.getAddress().getZipcode())
                .cName(user.getCompany().getName())
                .cCatchPhrase(user.getCompany().getCatchPhrase())
                .cBusService(user.getCompany().getBs())
                .build();
    }
    
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



    
}
