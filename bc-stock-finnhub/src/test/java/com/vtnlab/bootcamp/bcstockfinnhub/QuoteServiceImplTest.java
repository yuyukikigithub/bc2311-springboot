package com.vtnlab.bootcamp.bcstockfinnhub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;
import com.vtnlab.bootcamp.bcstockfinnhub.service.impl.QuoteServiceImpl;

@WebMvcTest(QuoteServiceImpl.class)
public class QuoteServiceImplTest {
    @MockBean
    private RestTemplate restTemplate;

    @Test
    void getQuoteTest(){
        Quote quote = new Quote(0, 0, 0, 0, 0, 0, 0, 0);
        Mockito.when(restTemplate.getForObject("quote.com", Quote.class)).thenReturn(quote);
        assertEquals(restTemplate.getForObject("quote.com", Quote.class),quote);
    }
}
