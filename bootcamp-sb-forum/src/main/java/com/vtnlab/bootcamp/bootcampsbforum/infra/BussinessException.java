package com.vtnlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public class BussinessException extends Exception{
    
    private String code;

    public BussinessException(Syscode syscode){
        super(syscode.getMessage());
        this.code=syscode.getCode();
    }
}
