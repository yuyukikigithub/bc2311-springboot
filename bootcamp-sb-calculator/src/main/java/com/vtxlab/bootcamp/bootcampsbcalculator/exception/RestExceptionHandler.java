package com.vtxlab.bootcamp.bootcampsbcalculator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Validated
public class RestExceptionHandler {

    @ExceptionHandler(CustomBusinessException.class)
    public ResponseEntity<ApiError> handleCustomBusinessException(CustomBusinessException ex){
        return new ResponseEntity<ApiError>(new ApiError(9,"Invalid Input"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(new ApiError(9,"Missing Input"));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiError> handleNoResourceFoundException(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(9,"Missing Input"));
    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     List<String> errors = new ArrayList<>();
    //     for (FieldError error : ex.getBindingResult().getFieldErrors()) {
    //         errors.add(error.getField() + ": " + error.getDefaultMessage());
    //     }
    //     for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
    //         errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    //     }

    //     return ResponseEntity.badRequest().body(new ApiError(9,"Invalid Input"));
    // }
    
    // @ExceptionHandler(BindException.class)
    // public ResponseEntity<ApiError> handleBindExceptions(BindException ex) {
    //     List<String> errors = new ArrayList<>();
    //     for (FieldError error : ex.getBindingResult().getFieldErrors()) {
    //         errors.add(error.getField() + ": " + error.getDefaultMessage());
    //     }
    //     for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
    //         errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    //     }

    //     return ResponseEntity.badRequest().body(new ApiError(9,"Invalid Input"));
    // }

    
}
