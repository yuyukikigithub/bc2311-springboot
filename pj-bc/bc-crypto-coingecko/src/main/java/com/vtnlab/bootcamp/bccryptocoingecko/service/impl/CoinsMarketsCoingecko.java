package com.vtnlab.bootcamp.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.BcUtil;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.Scheme;
import com.vtnlab.bootcamp.bccryptocoingecko.model.CoinsMarketsModel;
import com.vtnlab.bootcamp.bccryptocoingecko.model.idModel;
import com.vtnlab.bootcamp.bccryptocoingecko.service.CoinsMarketsService;

@Service
public class CoinsMarketsCoingecko implements CoinsMarketsService {


    @Value(value="${api.cgk.domain}")
    private String domain;

    @Value(value="${api.cgk.middlepart}")
    private String middlepart;
    
    @Value(value="${api.cgk.endpart}")
    private String endpart;

    @Value(value="${api.cgk.validId}")
    private String validId;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CoinsMarketsModel> getCoinsMarkets(String vs_currency, String ids) throws JsonProcessingException  {
        String coinsUrl = BcUtil.coinsUrl(vs_currency, ids);
        // String tryUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

        CoinsMarketsModel[] coinsMarketsModels = restTemplate.getForObject(coinsUrl, CoinsMarketsModel[].class);
        List<CoinsMarketsModel> listCoinsMarketsModels = Arrays.stream(coinsMarketsModels).collect(Collectors.toList());
        return listCoinsMarketsModels;

    }

    // @Override
    // public void setRedisKeyPair(String key, Object value) throws JsonProcessingException{
    //     redisHelper.set(key, value);
    // }

    @Override
    public List<String> getIds() {
        String idUrl = BcUtil.idUrl(Scheme.HTTPS, domain, validId);
        List<idModel> idModelList = Arrays.stream(restTemplate.getForObject(idUrl, idModel[].class)).collect(Collectors.toList());
        return idModelList.stream().map(e-> e.getId()).toList();
    }

    @Override
    public List<CoinsMarketsModel> getCoinsMarketsAllIds(String vs_currency) throws JsonProcessingException {
        String coinsUrl = BcUtil.coinsUrlAllIds(vs_currency);
        CoinsMarketsModel[] coinsMarketsModels = restTemplate.getForObject(coinsUrl, CoinsMarketsModel[].class);
        List<CoinsMarketsModel> listCoinsMarketsModels = Arrays.stream(coinsMarketsModels).collect(Collectors.toList());
        return listCoinsMarketsModels;
    }
    
}
