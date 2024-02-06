package com.vtnlab.bootcamp.bootcampsbforum.infra;

public class ResourceNotFound extends BusinessRuntimeException{

    public ResourceNotFound(Syscode syscode) {
        super(syscode);
        
    }
    
}
