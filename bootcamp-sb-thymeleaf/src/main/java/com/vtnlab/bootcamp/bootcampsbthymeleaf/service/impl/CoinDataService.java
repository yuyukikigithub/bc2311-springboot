package com.vtnlab.bootcamp.bootcampsbthymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bootcampsbthymeleaf.model.CoinData;
import com.vtnlab.bootcamp.bootcampsbthymeleaf.service.ApiService;

@Service
public class CoinDataService implements ApiService<CoinData> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CoinData> fetchData() {
        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

        CoinData[] response = restTemplate.getForObject(url,CoinData[].class);

        return Arrays.stream(response).collect(Collectors.toList());
    }
    
}
