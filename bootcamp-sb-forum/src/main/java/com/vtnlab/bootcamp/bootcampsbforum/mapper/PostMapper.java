package com.vtnlab.bootcamp.bootcampsbforum.mapper;

import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.entity.PostEntity;

@Component
public class PostMapper {
    
    public PostEntity mapEntity(UserPostRequestDTO.PostRequestDTO dto){
        return PostEntity.builder()
                            .title(dto.getTitle())
                            .body(dto.getBody())
                            .build();
    }
}
