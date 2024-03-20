package com.vtnlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    OK("000000","OK."), 
    NOTFOUND("100000","Not Found."),
    JPHCLIENT_NOT_AVAILABLE("10001","JsonPlaceHoler API is unavailable"),
    REST_CLIENT_EXCEPTION("90001","RestClient Exception"),
    NPE_EXCEPTION("90000","Runtime Exception - NPE"),
    GENERAL_EXCEPTION("99999","General Exception"),
    
    REQUEST_PARAM_EXCEPTION("900002", "Invalid Request Parameter")
    ;
    
    private String code;

    private String message;

    private Syscode (String code,String message){
        this.code=code;
        this.message=message;
    }
}