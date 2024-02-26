package com.vtnlab.bootcamp.bcstockfinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bcstockfinnhub.controller.QuoteOperation;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.DTOMapper;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.QuoteDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.ApiResp;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.RedisHelper;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.Symbol;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.Syscode;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;
import com.vtnlab.bootcamp.bcstockfinnhub.service.QuoteService;

@RestController
@RequestMapping(value="/stock/finnhub/api/v1/quote")
@Component
public class QuoteOperationImpl implements QuoteOperation{

    private String symbol;

    private QuoteDTO quoteDTOs;

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private RedisHelper redisHelper;

    @Override
    public ApiResp<QuoteDTO> getQuote(String symbol) throws JsonProcessingException {
        if (Symbol.getSymString(symbol)==null) {
            throw new IllegalArgumentException();
        }

        this.symbol=symbol;
        
        Quote quote = quoteService.getQuote(symbol);

        this.quoteDTOs= DTOMapper.quoteDTOMapper(quote);

        this.setRedisKeyPair();
        
        return ApiResp.<QuoteDTO>builder()
                    .code(Syscode.OK.getCode())
                    .message(Syscode.OK.getMessage())
                    .data(DTOMapper.quoteDTOMapper(quote))
                    .build();
        // return DTOMapper.quoteDTOMapper(quote);
    }

    @Scheduled(fixedRate=60000)
    public void setRedisKeyPair() throws JsonProcessingException{
        redisHelper.set(String.valueOf("stock:finnhub:quote:"+this.symbol), this.quoteDTOs);
    }
    
}
