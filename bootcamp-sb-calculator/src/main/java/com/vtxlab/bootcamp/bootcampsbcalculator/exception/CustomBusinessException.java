package com.vtxlab.bootcamp.bootcampsbcalculator.exception;


public class CustomBusinessException extends IllegalArgumentException{
    private int code;
    private String message;

    public CustomBusinessException(int code,String message){
        super(message);
        this.code=code;
    }
    
}
