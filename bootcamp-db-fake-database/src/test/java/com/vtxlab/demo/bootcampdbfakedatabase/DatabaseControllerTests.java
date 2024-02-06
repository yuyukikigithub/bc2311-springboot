package com.vtxlab.demo.bootcampdbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.vtxlab.demo.bootcampdbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.demo.bootcampdbfakedatabase.model.Cat;
import com.vtxlab.demo.bootcampdbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class) // Inject web layer related bean to context only. 
// so in this test env, @ComponentScan will ignore no @service, @Configuration etc
// but includes controller bean, mockmvc bean, etc
// specify testing component
// @SpringBootTest full env
// test controller, mock service
class DatabaseControllerTests {

    @Autowired
    private MockMvc mockMvc; // sim to Postman

    // @Autowired cannot autowire service bean in WebMvcTest env
    @MockBean // assume has this bean in context
    // because Controller Bean need to autowired catDatabaseService
    private CatDatabaseService catDatabaseService;

    // @MockBean
    // private String tutorName;

    @Test
    void testGetCat() throws Exception{
        // assumption
        Cat mockedReturnCat = new Cat("abc",3);
        // when
        Mockito.when(catDatabaseService.getFromMemory(1)).thenReturn(mockedReturnCat);
        Mockito.when(catDatabaseService.setToMemory(1, mockedReturnCat)).thenReturn(mockedReturnCat);
        // assert
        // mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/cat/{idx}","1"))
        //     .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("abc"))
        //     .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(3))
        //     .andDo(MockMvcResultHandlers.print());

            mockMvc.perform(get("/api/v2/cat/{idx}","1"))
            .andExpect(status().isOk()) // http code 200-ok
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("abc"))
            .andExpect(jsonPath("$.age").value(3))
            .andDo(print());

            //wrong
            mockMvc.perform(get("/api/v2/cat2/{idx}","1"))
                .andExpect(status().isNotFound()) // http code 404
                .andDo(print());

    }

    @Test
    void testPostCat() throws Exception{
        // assumption
        Cat mockedReturnCat = new Cat("abc",3);
        // when
        Mockito.when(catDatabaseService.getFromMemory(1)).thenReturn(mockedReturnCat);
        Mockito.when(catDatabaseService.setToMemory(1, mockedReturnCat)).thenReturn(mockedReturnCat);
        // assert

        String jsonBody="{ \"name\": \"abc\", \"age\": 3 }";
        
        mockMvc.perform(post("/api/v2/cat/{idx}","1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("abc"))
                .andExpect(jsonPath("$.age").value(3))
            .andDo(print());
    }

    @Test
    void testDeleteCat() throws Exception{
        // assumption
        Cat mockedReturnCat = new Cat("abc",3);
        // when
        Mockito.when(catDatabaseService.getFromMemory(1)).thenReturn(mockedReturnCat);
        Mockito.when(catDatabaseService.deleteMemory(1)).thenReturn(mockedReturnCat);
        // assert
        
        mockMvc.perform(delete("/api/v2/cat/{idx}","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                
                
            .andDo(print());
    }

    @Test
    void testPatchCat() throws Exception{
        // assumption
        Cat mockedReturnCat = new Cat("abc",3);
        // when
        Mockito.when(catDatabaseService.getFromMemory(1)).thenReturn(mockedReturnCat);
        Mockito.when(catDatabaseService.patchNameToMemory(1,"def")).thenReturn(new Cat("def",3));
        // assert
        
        mockMvc.perform(patch("/api/v2/cat/{idx}/name/{name}","1","def")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("def"))
                .andExpect(jsonPath("$.age").value(3))
                
                
            .andDo(print());
    }

    // @Test
    // void testThrowCat() throws Exception{

    //     Mockito.when(catDatabaseService.getFromMemory(11)).thenThrow(new IllegalArgumentException() );
      
    //     mockMvc.perform(get("/api/v2/cat/{idx}","11")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk())
    //             .andDo(print());
    // }
}
