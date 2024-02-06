package com.vtxlab.bootcamp.bootcampsbcalculator.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.bootcamp.bootcampsbcalculator.model.Answer;



public interface CalculatorOperation {
    @GetMapping(value="/{x}/{y}/{operation}")
    Answer getDivision(@PathVariable String x,@PathVariable  String y, @PathVariable String operation) throws Exception;

    @GetMapping(value="")
    Answer getDivision1(@RequestParam(name="x")  String x,@RequestParam(name="y")  String y, @RequestParam(name="operation") String operation) throws Exception;
   
    @PostMapping(value="")
    Answer getAnswerByBody(@RequestBody Answer answer) throws Exception;

    
}
