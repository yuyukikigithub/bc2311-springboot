package com.vtnlab.bootcamp.bootcampsbforum.infra;

public enum Scheme {
    HTTPS, HTTP,;

    public String lowercaseName(){
        return this.name().toLowerCase();
    }
    
}
