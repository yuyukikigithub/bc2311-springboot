package com.vtnlab.bootcamp.bcstockfinnhub.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcstockfinnhub.infra.BcUtil;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.Symbol;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;
import com.vtnlab.bootcamp.bcstockfinnhub.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Quote getQuote(String sym) {
        String quoteUrl = BcUtil.url("quote",sym );
        Quote quote = restTemplate.getForObject(quoteUrl,Quote.class);
        return quote;
    }
    
}
