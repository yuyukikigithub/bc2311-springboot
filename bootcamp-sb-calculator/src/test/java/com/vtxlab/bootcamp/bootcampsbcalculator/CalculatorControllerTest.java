//CalculatorControllerTest.java
package com.vtxlab.bootcamp.bootcampsbcalculator;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl.CalculatorController;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Answer;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorServiceInf;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorServiceInf calculatorServiceInf;
    // private OperationMethod operationMethod;

    @SuppressWarnings("null")
    @Test
    void testGetDivision() throws Exception{
        Answer ans = new Answer("1","3","add","4.0");
        Mockito.when(calculatorServiceInf.getDivision(BigDecimal.valueOf(1),BigDecimal.valueOf(3),"add")).thenReturn(ans);

        mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","1","3","add"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON) )
            .andExpect(jsonPath("$.x").value("1"))
            .andExpect(jsonPath("$.y").value("3"))
            .andExpect(jsonPath("$.operation").value("add"))
            .andExpect(jsonPath("$.result").value("4.0"))
            .andDo(print());
    }

    @SuppressWarnings("null")
    @Test
    void testGetDivision1() throws Exception{

        Answer ans = new Answer("1","3","add","4.0");
        Mockito.when(calculatorServiceInf.getDivision(BigDecimal.valueOf(1),BigDecimal.valueOf(3),"add")).thenReturn(ans);

        mockMvc.perform(get("/api/v1")
            .param("x","1")
            .param("y","3")
            .param("operation", "add"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.x").value("1"))
            .andExpect(jsonPath("$.y").value("3"))
            .andExpect(jsonPath("$.operation").value("add"))
            .andExpect(jsonPath("$.result").value("4.0"))
            .andDo(print());
    }

    @SuppressWarnings("null")
    @Test
    void testGetAnswerByBody() throws Exception{

        Answer ans = new Answer("1","3","add","4.0");
        Answer request = new Answer("1","3","add",null);
        Mockito.when(calculatorServiceInf.getAnswerByBody(request)).thenReturn(ans);
        String requestBody = "{ \"x\": \"1\", \"y\": \"3\", \"operation\": \"add\"}";
        

        mockMvc.perform(post("/api/v1")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.x").value("1"))
            .andExpect(jsonPath("$.y").value("3"))
            .andExpect(jsonPath("$.operation").value("add"))
            .andExpect(jsonPath("$.result").value("4.0"))
            .andDo(print())
            ;
    }

    
}
