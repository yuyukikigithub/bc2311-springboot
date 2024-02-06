package com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album {
    private int userId;
    private int id;
    private String title;
}
