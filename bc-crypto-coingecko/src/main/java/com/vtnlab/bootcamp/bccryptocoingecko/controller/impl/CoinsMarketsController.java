package com.vtnlab.bootcamp.bccryptocoingecko.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bccryptocoingecko.controller.CoinsMarketsOperation;
import com.vtnlab.bootcamp.bccryptocoingecko.dto.CoinsMarketsModelDTO;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.ApiResp;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.Currency;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.RedisHelper;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.Syscode;
import com.vtnlab.bootcamp.bccryptocoingecko.model.DTOMapper;
import com.vtnlab.bootcamp.bccryptocoingecko.service.CoinsMarketsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/crypto/coingecko/api/v1/coins")
@Component
public class CoinsMarketsController implements CoinsMarketsOperation{

    @Autowired
    private CoinsMarketsService coinsMarketsService;

    @Autowired
    private RedisHelper redisHelper;

    private String vs_currency;
    private List<CoinsMarketsModelDTO> dtos;

    @Override
    public ApiResp<List<CoinsMarketsModelDTO>> getCoinsMarkets(String vs_currency, String ids) throws JsonProcessingException {
        if (Currency.getCurrString(vs_currency)==null) {
            throw new IllegalArgumentException("invalid currency");
        }
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            if (!(coinsMarketsService.getIds().contains(id))) {
                throw new IllegalArgumentException("invalid ids");
            }
        }

        this.vs_currency=String.valueOf("crypto:coingecko:coins-markets:"+vs_currency+":"+ids);
        
        List<CoinsMarketsModelDTO> coinsMarketsModelDTOs= coinsMarketsService.getCoinsMarkets(vs_currency, ids).stream().map(e->{
                                                                    return DTOMapper.coinsMarktetsModelDTOMapper(e);
                                                            }).toList();
        this.dtos=coinsMarketsModelDTOs;

        this.setRedisKeyPair();

        if (redisHelper.isKeyExpired(String.valueOf("crypto:coingecko:coins-markets:"+vs_currency+":"+ids))==-2) {
            return  ApiResp.<List<CoinsMarketsModelDTO>>builder()
                        .code(Syscode.EXPIRY.getCode())
                        .message(Syscode.EXPIRY.getMessage())
                        .data(null)
                        .build();
        }

        return ApiResp.<List<CoinsMarketsModelDTO>>builder()
            .code(Syscode.OK.getCode())
            .message(Syscode.OK.getMessage())
            .data(coinsMarketsModelDTOs).build();
        
    }

    @Scheduled(fixedRate=60000)
    public void setRedisKeyPair() throws JsonProcessingException{
        redisHelper.set(this.vs_currency, this.dtos);
        System.out.println("hello from setRedisKeyPair");
    }

    

    
}
