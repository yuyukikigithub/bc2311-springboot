package com.vtnlab.bootcamp.bcstockfinnhub.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcstockfinnhub.infra.BcUtil;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Symbol;
import com.vtnlab.bootcamp.bcstockfinnhub.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    RestTemplate restTemplate;
    
    @Override
    public Profile getProfile(String symbol) {
        String profileUrl = BcUtil.url("stock", symbol);
        Profile profile=restTemplate.getForObject(profileUrl,Profile.class);
        return profile;
    }

    @Override
    public List<Symbol> getSymbol() {
        String symbolUrl = BcUtil.urlSymbol();
        List<Symbol> symbol=Arrays.asList(restTemplate.getForObject(symbolUrl, Symbol[].class));
        return symbol;
    }
    
}
