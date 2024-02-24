package com.vtnlab.bootcamp.bccryptocoingecko.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bccryptocoingecko.model.CoinsMarketsModel;

public interface CoinsMarketsService {
    List<CoinsMarketsModel> getCoinsMarkets(String vs_currency, String ids)  throws JsonProcessingException  ;

    List<String> getIds();

    
} 