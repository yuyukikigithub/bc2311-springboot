package com.vtnlab.bootcamp.bccryptocoingecko.exception;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.vtnlab.bootcamp.bccryptocoingecko.infra.ApiResp;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.Syscode;

@RestControllerAdvice
@Validated
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResp<String> handleIllegalArgumentException(IllegalArgumentException ex){
        return ApiResp.<String>builder().code(Syscode.BAD_REQUEST.getCode()).message(Syscode.BAD_REQUEST.getMessage()).data(ex.getMessage()).build();
    }

    @ExceptionHandler(RestClientException.class)
    public ApiResp<String> handleRestClientException(RestClientException ex){
        return ApiResp.<String>builder().code(Syscode.BAD_REQUEST.getCode()).message(Syscode.BAD_REQUEST.getMessage()).data("RestClientException").build();
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ApiResp<String> handleNoResourceFoundException(NoResourceFoundException ex){
        return ApiResp.<String>builder().code(Syscode.BAD_REQUEST.getCode()).message(ex.getMessage()).data(null).build();
    }
}
