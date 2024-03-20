package com.vtnlab.bootcamp.bcstockfinnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.QuoteDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.ApiResp;

public interface QuoteOperation {
    @GetMapping(value="")
    ApiResp<QuoteDTO> getQuote(@RequestParam String symbol) throws JsonProcessingException ;
}
