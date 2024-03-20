package com.vtnlab.bootcamp.bootcampsbforum.infra;

public class RequestParamException extends BusinessRuntimeException{
    
    public RequestParamException(Syscode syscode){
        super(syscode);
    }
}
