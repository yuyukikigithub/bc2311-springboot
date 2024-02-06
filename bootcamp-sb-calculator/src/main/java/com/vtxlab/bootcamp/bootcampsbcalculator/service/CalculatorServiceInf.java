package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import java.math.BigDecimal;

import com.vtxlab.bootcamp.bootcampsbcalculator.model.Answer;

public interface CalculatorServiceInf {
    public Answer getDivision(BigDecimal x, BigDecimal y, String op) throws Exception;

    public Answer getAnswerByBody(Answer answer) throws Exception;

    
}
