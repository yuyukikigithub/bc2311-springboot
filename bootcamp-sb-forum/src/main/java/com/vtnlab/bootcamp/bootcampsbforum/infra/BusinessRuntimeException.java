package com.vtnlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {
    
    private String code;
    public BusinessRuntimeException(Syscode syscode){
        super(syscode.getMessage());
        this.code = syscode.getCode();
    }
    //throwable subclass
    // 1. "throw" an object of this subclass
    // 2. catch the object thrown by method being called 
}
