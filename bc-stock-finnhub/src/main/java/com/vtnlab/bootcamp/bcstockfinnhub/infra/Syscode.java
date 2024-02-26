package com.vtnlab.bootcamp.bcstockfinnhub.infra;

import lombok.Getter;

@Getter
public enum Syscode {
    OK("00000","OK"),
    BAD_REQUEST("40000","Bad_Request"),
    NOT_FOUND("40400","Not_Found"),
    INTERNAL_SERVER_ERROR("500","Internal_Server_Error"),
    EXPIRY("90000","RestClientException - Coingecko Service is unavailable")
    ;
    
    private String code;
    private String message;

    private Syscode(String code, String message){
        this.code=code;
        this.message=message;
    }

}
