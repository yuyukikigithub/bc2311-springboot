package com.vtnlab.bootcamp.bccryptocoingecko;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bccryptocoingecko.model.CoinsMarketsModel;
import com.vtnlab.bootcamp.bccryptocoingecko.model.idModel;
import com.vtnlab.bootcamp.bccryptocoingecko.service.impl.CoinsMarketsCoingecko;

@WebMvcTest(CoinsMarketsCoingecko.class)
public class CoinsMarketsCoingeckoTest {
    @MockBean
    private RestTemplate restTemplate;

    @Test
    void testIdUrl(){
        Mockito.when(restTemplate.getForObject("coinlist.com", idModel[].class)).thenReturn(new idModel[] {new idModel("bitcoin", "btc", "bitcoin")});
        assertEquals(Arrays.stream(restTemplate.getForObject("coinlist.com", idModel[].class)).collect(Collectors.toList()).stream().map(e-> e.getId()).toList(), List.of(String.valueOf("bitcoin")));
    }

    @Test
    void testCoinsUrl(){
        Mockito.when(restTemplate.getForObject("coinsmarkets.com", CoinsMarketsModel[].class)).thenReturn(new CoinsMarketsModel[] {new CoinsMarketsModel("bitcoin", null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, null, null)});
        assertEquals(Arrays.stream(restTemplate.getForObject("coinsmarkets.com", CoinsMarketsModel[].class)).collect(Collectors.toList()), List.of(new CoinsMarketsModel("bitcoin", null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, null, null)));
    }

    
}
