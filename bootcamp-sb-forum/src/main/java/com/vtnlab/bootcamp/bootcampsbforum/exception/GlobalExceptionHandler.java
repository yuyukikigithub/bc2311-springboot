package com.vtnlab.bootcamp.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtnlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;


@RestControllerAdvice // nonstop catch and add object in between beans
public class GlobalExceptionHandler {
    @ExceptionHandler(JPHClientException.class)
    @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    public ApiResp<Void> jphCliengtExceptionHandler(JPHClientException e){
        return ApiResp.<Void>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();

    } 

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(value=HttpStatus.OK)
    public ApiResp<Void> npeExceptionHandler(ResourceNotFound e){
        return ApiResp.<Void>builder()
                .code(Syscode.NOTFOUND.getCode())
                .message(Syscode.NOTFOUND.getMessage())
                .data(null)
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    public ApiResp<Void> npeExceptionHandler(NullPointerException e){
        return ApiResp.<Void>builder()
                .code(Syscode.NPE_EXCEPTION.getCode())
                .message(Syscode.NPE_EXCEPTION.getMessage())
                .data(null)
                .build();

    } 
}
