package com.vtnlab.bootcamp.bootcampsbforum.dto.gov;

import lombok.Getter;
import lombok.Setter;

//User-> UserDTO (ignore some field)
@Getter
@Setter
public class UserDTO {
    private int id;
    private String email;
    private String phone;
}
