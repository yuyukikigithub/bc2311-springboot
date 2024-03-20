package com.vtnlab.bootcamp.bootcampsbforum.exception;

import java.util.Comparator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtnlab.bootcamp.bootcampsbforum.infra.GlobalExceptionHandler;
import com.vtnlab.bootcamp.bootcampsbforum.infra.JPHClientException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.RequestParamException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice // Bean: @ControllerAdvice + @ResponseBody
public class LocalExceptionHandler extends GlobalExceptionHandler{
    @ExceptionHandler(JPHClientException.class)
    @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    public ApiResp<Void> jphCliengtExceptionHandler(JPHClientException e){
        return ApiResp.<Void>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();

    } 

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    public ApiResp<Void> constraintValidationExceptionHandler(RequestParamException e){
        return ApiResp.<Void>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();

    } 

    @ExceptionHandler(RequestParamException.class)
    @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    public ApiResp<Void> requestParamExceptionHandler(RequestParamException e){
        return ApiResp.<Void>builder()
                .code(e.getCode())
                .message(e.getMessage())
                .data(null)
                .build();

    } 

    // @ExceptionHandler(RestClientException.class)
    // @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    // public ApiResp<Void> jphCliengtExceptionHandler(RestClientException e){
    //     return ApiResp.<Void>builder()
    //             .code(Syscode.REST_CLIENT_EXCEPTION.getCode())
    //             .message(Syscode.REST_CLIENT_EXCEPTION.getMessage())
    //             .data(null)
    //             .build();

    // } 

    // @ExceptionHandler(ResourceNotFound.class)
    // @ResponseStatus(value=HttpStatus.OK)
    // public ApiResp<Void> npeExceptionHandler(ResourceNotFound e){
    //     return ApiResp.<Void>builder()
    //             .code(Syscode.NOTFOUND.getCode())
    //             .message(Syscode.NOTFOUND.getMessage())
    //             .data(null)
    //             .build();
    // }

    // @ExceptionHandler(NullPointerException.class)
    // @ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT)
    // public ApiResp<Void> npeExceptionHandler(NullPointerException e){
    //     return ApiResp.<Void>builder()
    //             .code(Syscode.NPE_EXCEPTION.getCode())
    //             .message(Syscode.NPE_EXCEPTION.getMessage())
    //             .data(null)
    //             .build();

    // } 

//     @ExceptionHandler(Exception.class)
//     @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
//     public ApiResp<Void> npeExceptionHandler(Exception e) {
//         return ApiResp.<Void>builder() //
//             .code(Syscode.GENERAL_EXCEPTION.getCode()) //
//             .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
//             .data(null) //
//             .build();
//   }
    
}
