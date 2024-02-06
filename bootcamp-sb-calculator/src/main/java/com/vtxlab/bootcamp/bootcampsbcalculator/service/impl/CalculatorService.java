package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.vtxlab.bootcamp.bootcampsbcalculator.exception.CustomBusinessException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Answer;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.OperationMethod;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorServiceInf;

@Service
public class CalculatorService implements CalculatorServiceInf {
    @Override
    public Answer getDivision(BigDecimal x, BigDecimal y, String op) throws CustomBusinessException {
        
        Answer result = new Answer();

        if (op.equals(OperationMethod.getOpFmVal(op)) && OperationMethod.getOpFmVal(op) != null) {
            switch (op) {
                case "add":
                    result.setResult(String.valueOf(x.add(y).setScale(1)));
                    break;
                case "sub":
                    result.setResult(String.valueOf(x.subtract(y).setScale(1)));
                    break;
                case "mul":
                    result.setResult(String.valueOf(x.multiply(y).setScale(1)));
                    break;
                case "div":
                    try {
                        result.setResult(String.valueOf(x.divide(y, 5, RoundingMode.HALF_UP)));
                    } catch (Exception e) {
                        throw new CustomBusinessException(9, "Invalid Input");
                    }
                    break;
                default:
                    // break;
                    throw new CustomBusinessException(9, "Invalid Input");
                }
        } else {
            throw new CustomBusinessException(9, "Invalid Input");
        }
        result.setX(String.valueOf(x));
        result.setY(String.valueOf(y));
        result.setOperation(op);
        return result;

    }

    @Override
    public Answer getAnswerByBody(Answer answer) throws Exception {

        Answer result = new Answer();

        BigDecimal bigX = BigDecimal.valueOf(Long.parseLong(answer.getX()));
        BigDecimal bigY = BigDecimal.valueOf(Long.parseLong(answer.getY()));
        String operation = OperationMethod.getOpFmVal(answer.getOperation());

        if (operation != null) {
            switch (operation) {
                case "add":
                    result.setResult(String.valueOf(bigX.add(bigY).setScale(1)));
                    break;
                case "sub":
                    result.setResult(String.valueOf(bigX.subtract(bigY).setScale(1)));
                    break;
                case "mul":
                    result.setResult(String.valueOf(bigX.multiply(bigY).setScale(1)));
                    break;
                case "div":
                    try {
                        result.setResult(String.valueOf(bigX.divide(bigY, 5, RoundingMode.HALF_UP)));
                    } catch (Exception e) {
                        throw new CustomBusinessException(9, "Invalid Input");
                    }

                    break;
                default:
                    break;
            }
        } else {
            throw new CustomBusinessException(9, "Invalid Input");
        }
        result.setX(String.valueOf(bigX));
        result.setY(String.valueOf(bigY));
        result.setOperation(operation);
        return result;
    }

    public static void main(String[] args) throws Exception {
        CalculatorService cal = new CalculatorService();
        
        System.out.println(cal.getDivision(new BigDecimal("10"),new BigDecimal("10"),"dilv"));
    }

}
