package com.vtnlab.bootcamp.bootcampsbforum.dto.gov;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@AllArgsConstructor
@Getter
@Builder
public class CommentDTO {
    private int id; // comment id
    private String name;
    private String email;
    private String body;
}
