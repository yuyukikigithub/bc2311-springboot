package com.vtnlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public class JPHClientException extends BusinessRuntimeException{


    public JPHClientException(Syscode syscode) {
        super(syscode);
       
    }
    
}
