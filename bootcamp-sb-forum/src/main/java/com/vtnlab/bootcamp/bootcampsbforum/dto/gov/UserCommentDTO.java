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
public class UserCommentDTO {
    private int id;
    private String username;
    private String email;
    private String phone;

    @JsonProperty(value="comments")
    private List<CommentDTO> commentDTOs;
}
