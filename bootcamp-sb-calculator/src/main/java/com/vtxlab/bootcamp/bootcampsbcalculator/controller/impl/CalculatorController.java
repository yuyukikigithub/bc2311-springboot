package com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.bootcamp.bootcampsbcalculator.controller.CalculatorOperation;
import com.vtxlab.bootcamp.bootcampsbcalculator.exception.CustomBusinessException;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.IsRightFormat;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Answer;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorServiceInf;

@Controller
@ControllerAdvice
@ResponseBody
@RequestMapping(value="/api/v1")
@Validated
public class CalculatorController implements CalculatorOperation{

    @Autowired
    private CalculatorServiceInf calculatorServiceInf;

    // public boolean isRightFormat(String x, String y){
    //     boolean result = true;
    //     for (int i = 0; i < x.length(); i++) {
    //         if ((int) x.charAt(i)==46 || ((int) x.charAt(i)<=57 && (int) x.charAt(i)>=48)) {
    //             continue;
    //         }
    //         return false;
    //     }
    //     for (int i = 0; i < y.length(); i++) {
    //         if ((int) y.charAt(i)==46 || ((int) y.charAt(i)<=57 && (int) y.charAt(i)>=48)) {
    //             continue;
    //         }
    //         return false;
    //     }
    //     return result;
    // }

    @Override
    public Answer getDivision(String x, String y, String operation) throws Exception {
        
        if (!IsRightFormat.isRightFormat(x,y)) {
            throw new CustomBusinessException(9, "Invalid Input");
        }

        
        BigDecimal bigx=new BigDecimal(x);
        BigDecimal bigy=new BigDecimal(y);
        
        return calculatorServiceInf.getDivision(bigx, bigy,operation);
    }

    @Override
    public Answer getDivision1(String x, String y, String operation) throws Exception {
        if (!IsRightFormat.isRightFormat(x,y)) {
            throw new CustomBusinessException(9, "Invalid Input");
        }
        
        BigDecimal bigx=new BigDecimal(x);
        BigDecimal bigy=new BigDecimal(y);
        
        return calculatorServiceInf.getDivision(bigx, bigy,operation);
    }

    @Override
    public Answer getAnswerByBody(Answer answer) throws Exception {
        return calculatorServiceInf.getAnswerByBody(answer);
    }

    public static void main(String[] args) {
        System.out.println((int) '0'>=48);
    }
    
    
}
