// CalculatorServiceTest.java
package com.vtxlab.bootcamp.bootcampsbcalculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.vtxlab.bootcamp.bootcampsbcalculator.exception.CustomBusinessException;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.OperationMethod;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorServiceInf;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.impl.CalculatorService;

@WebMvcTest(CalculatorService.class)
public class CalculatorServiceTest {
    // @Autowired
    // private MockMvc mockMvc;
    @Autowired
    // @MockBean
    private CalculatorServiceInf calculatorServiceInf;
    
    @Test
    public void testThrowsException() {

        assertThrows(NumberFormatException.class, () -> {
            
            calculatorServiceInf.getDivision(new BigDecimal("10"),new BigDecimal("10d"),"div"); // Call the method that is expected to throw an exception
        });
    }

    @Test
    public void testThrowsCustomException() {
        try (MockedStatic<OperationMethod> mockedStatic = mockStatic(OperationMethod.class)) {
            
            mockedStatic.when(() -> OperationMethod.getOpFmVal("dilv")).thenReturn(null);
            
            assertThrows(CustomBusinessException.class, () -> {
                calculatorServiceInf.getDivision(new BigDecimal("10"),//
                new BigDecimal("10"),"dilv"); 
            });
        }
    }

    // @Test
    // public void testGetDivisionThrowsCustomException() {
    //     assertThrows(CustomBusinessException.class, () -> {
    //         calculatorServiceInf.getDivision(new BigDecimal("10"),//
    //         new BigDecimal("10"),"dilv"); 
    //     });
    // }

    // @Test
    // public void test () {
    //     Mockito.when(OperationMethod.getOpFmVal("div")).thenReturn("div");
    //     assertThat(calculatorServiceInf.getDivision(new BigDecimal("10"), new BigDecimal("10"), "div") );
    // }

    // @SuppressWarnings("null")
    // @Test
    // void testFailGetDivision1() throws Exception{

    //     Mockito.when(calculatorServiceInf.getDivision(BigDecimal.valueOf(1),BigDecimal.valueOf(3),"addl")).thenThrow(CustomBusinessException.class);

    //     mockMvc.perform(get("/api/v1")
    //         .param("x","1")
    //         .param("y","3")
    //         .param("operation", "addl"))
    //         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    //         .andExpect(jsonPath("$.code").value(9))
    //         .andExpect(jsonPath("$.message").value("Invalid Input"))
            
    //         .andDo(print());
    // }

}
