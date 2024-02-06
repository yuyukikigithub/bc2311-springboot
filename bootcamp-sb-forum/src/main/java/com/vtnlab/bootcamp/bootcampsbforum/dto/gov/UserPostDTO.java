package com.vtnlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {
    private int id;
    private String username;
    private String email;
    private String phone;

    @JsonProperty(value="posts") // brief for name
    private List<PostDTO> postDTOs;
}
