package com.vtxlab.bootcamp.bootcampjavadto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatDto {
    private String description; // "Cat Name: John, Cat Age: 1"

    private String logo;
}
