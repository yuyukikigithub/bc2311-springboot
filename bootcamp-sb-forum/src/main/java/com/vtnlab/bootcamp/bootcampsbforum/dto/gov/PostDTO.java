package com.vtnlab.bootcamp.bootcampsbforum.dto.gov;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    private int id;
    private String title;
    private String body;
}
