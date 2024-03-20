package com.vtnlab.bootcamp.bcproductdata.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.vtnlab.bootcamp.bcproductdata.infra.ApiResp;
import com.vtnlab.bootcamp.bcproductdata.infra.Syscode;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ApiResp<String> handleIllegalArgumentException(NullPointerException ex){
        return ApiResp.<String>builder().code(Syscode.INVALID_INPUT.getSyscode()).message(Syscode.INVALID_INPUT.getMessage()).data(ex.getLocalizedMessage()).build();
    }

    @ExceptionHandler(RestClientException.class)
    public ApiResp<String> handleRestClientException(RestClientException ex){
        return ApiResp.<String>builder().code(Syscode.INVALID_OPERATION.getSyscode()).message(Syscode.INVALID_OPERATION.getMessage()).data(ex.getLocalizedMessage()).build();
    }
}
