package com.vtnlab.bootcamp.bccryptocoingecko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import com.vtnlab.bootcamp.bccryptocoingecko.controller.CoinsMarketsOperation;
import com.vtnlab.bootcamp.bccryptocoingecko.controller.impl.CoinsMarketsController;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.Currency;
import com.vtnlab.bootcamp.bccryptocoingecko.model.CoinsMarketsModel;
import com.vtnlab.bootcamp.bccryptocoingecko.model.CoinsMarketsModel.Roi;
import com.vtnlab.bootcamp.bccryptocoingecko.service.CoinsMarketsService;

import static org.hamcrest.Matchers.*;
@SpringBootTest
// @WebMvcTest(CoinsMarketsController.class)
public class CoinsMarketsControllerTest {
    // @Autowired
    // private MockMvc mockMvc;

    @Autowired
    private CoinsMarketsOperation coinsMarketsOperation;

    @MockBean
    private CoinsMarketsService coinsMarketsService;

    @Test
    void testCurrency() {
        assertEquals(Currency.getCurrString("usd"),"usd");
    }

    // @Test
    // void testException(){
    //     // assertThatThrownBy(() -> getCurrString("ussd")).isInstanceOf(IllegalArgumentException.class);
    //     assertThrows(IllegalArgumentException.class,()->{
    //         coinsMarketsOperation.getCoinsMarkets("ussd","bitcoin");
    //     });
    // }

    

    // @SuppressWarnings("null")
    // @Test
    // void testGetCoinsMarkets() throws Exception {
    //     Mockito.when(coinsMarketsService.getIds()).thenReturn(List.of("bitcoin"));
    //     List<CoinsMarketsModel> mo = new ArrayList<>(List.of(new CoinsMarketsModel("bitcoin", "a", "a", "a", 0, Long.valueOf(9), Long.valueOf(9), Long.valueOf(9), Long.valueOf(9), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "a", 0, 0, "a", new Roi(0, "a", 0), "a")));
    //     Mockito.when(coinsMarketsService.getCoinsMarkets("usd","bitcoin")).thenReturn(mo);
    //     mockMvc.perform(get("/crypto/coingecko/api/v1/coins")
    //     .param("vs_currency", "usd")
    //     .param("ids", "bitcoin"))
    //     .andExpect(jsonPath("$.code").value("00000"))
    //     .andExpect(jsonPath("$.message").value("OK"))
    //     .andExpect(jsonPath("$.data").isArray())
    //     .andExpect(jsonPath("$.data",hasSize(1)))
    //     .andExpect(jsonPath("$.data[0].id",is("bitcoin")))
    //     .andExpect(jsonPath("$.data[0].symbol",is("a")))
    //     .andExpect(jsonPath("$.data[0].name",is("a")))
    //     .andExpect(jsonPath("$.data[0].image",is("a")))
    //     .andExpect(jsonPath("$.data[0].current_price",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].market_cap",is(9)))
    //     .andExpect(jsonPath("$.data[0].market_cap_rank",is(9)))
    //     .andExpect(jsonPath("$.data[0].fully_diluted_valuation",is(9)))
    //     .andExpect(jsonPath("$.data[0].total_volume",is(9)))
    //     .andExpect(jsonPath("$.data[0].high_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].low_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].price_change_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].price_change_percentage_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].market_cap_change_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].market_cap_change_percentage_24h",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].circulating_supply",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].total_supply",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].max_supply",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].ath",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].ath_change_percentage",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].ath_date",is("a")))
    //     .andExpect(jsonPath("$.data[0].atl",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].atl_change_percentage",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].atl_date",is("a")))
    //     .andExpect(jsonPath("$.data[0].roi.times",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].roi.currency",is("a")))
    //     .andExpect(jsonPath("$.data[0].roi.percentage",is(0.0)))
    //     .andExpect(jsonPath("$.data[0].last_updated",is("a")))
    //     .andDo(print());
    // }

}
