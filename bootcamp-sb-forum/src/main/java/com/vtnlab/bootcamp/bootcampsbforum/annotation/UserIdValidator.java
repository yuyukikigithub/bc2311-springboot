package com.vtnlab.bootcamp.bootcampsbforum.annotation;

import java.util.Objects;

import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserIdRQDTO;
import com.vtnlab.bootcamp.bootcampsbforum.infra.RequestParamException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.Syscode;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<UserIdChecker,UserIdRQDTO> {

    @Override
    public boolean isValid(UserIdRQDTO dto, ConstraintValidatorContext context) {
        if (!Objects.nonNull(dto)) 
            return false;
        try {
            Integer i = Integer.valueOf(dto.getId());
            return i>0;
        } catch (NumberFormatException e) {
            // throw new RequestParamException(Syscode.REQUEST_PARAM_EXCEPTION);
            return false;
        }
        
    }
    
    
}
