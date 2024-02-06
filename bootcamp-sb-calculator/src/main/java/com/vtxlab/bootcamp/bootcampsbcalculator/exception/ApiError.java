package com.vtxlab.bootcamp.bootcampsbcalculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private int code;
    private String message;

    
}
