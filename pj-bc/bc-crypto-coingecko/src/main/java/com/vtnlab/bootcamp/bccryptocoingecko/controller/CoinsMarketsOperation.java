package com.vtnlab.bootcamp.bccryptocoingecko.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bccryptocoingecko.dto.CoinsMarketsModelDTO;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.ApiResp;


public interface CoinsMarketsOperation {
    @GetMapping(value="")
    ApiResp<List<CoinsMarketsModelDTO>> getCoinsMarkets(@RequestParam String vs_currency, @RequestParam String ids) throws JsonProcessingException;
    
    @GetMapping(value="/marketTry")
    ApiResp<List<CoinsMarketsModelDTO>> getCoinsMarketsAllIds(@RequestParam String vs_currency) throws JsonProcessingException;

    @GetMapping(value="/markets")
    ApiResp<List<String>> getCoinsMarketsAllCoinIds(@RequestParam String vs_currency) throws JsonProcessingException;
    
}