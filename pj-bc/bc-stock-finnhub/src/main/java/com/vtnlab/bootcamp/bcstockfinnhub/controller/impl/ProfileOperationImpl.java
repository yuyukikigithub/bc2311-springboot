package com.vtnlab.bootcamp.bcstockfinnhub.controller.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bcstockfinnhub.controller.ProfileOperation;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.DTOMapper;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.ProfileDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.SymbolDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.ApiResp;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.RedisHelper;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.Symbol;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.Syscode;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.service.ProfileService;

@RestController
@RequestMapping(value="/stock/finnhub/api/v1/profile2")
@Component
@CrossOrigin(origins ="http://localhost:8092/")
public class ProfileOperationImpl implements ProfileOperation{

    private String symbol;

    private ProfileDTO profileDTO;

    @Autowired
    private ProfileService profileService; 

    @Autowired
    private RedisHelper redisHelper;

    @Override
    @CrossOrigin
    public ApiResp<ProfileDTO> getProfile(String symbol) throws JsonProcessingException {
        // if (Symbol.getSymString(symbol)==null) {
        //     throw new IllegalArgumentException();
        // }

        this.symbol=symbol;
        
        Profile profile = profileService.getProfile(symbol);

        this.profileDTO=DTOMapper.profileDTOMapper(profile);

        this.setRedisKeyPair();

        if (redisHelper.isKeyExpired(String.valueOf("stock:finnhub:profile2:"+symbol))==-2) {
            return  ApiResp.<ProfileDTO>builder()
                        .code(Syscode.EXPIRY.getCode())
                        .message(Syscode.EXPIRY.getMessage())
                        .data(null)
                        .build();
        }
        
        return ApiResp.<ProfileDTO>builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .data(DTOMapper.profileDTOMapper(profile))
        .build();
                
    }

    @Scheduled(fixedRate=60000)
    public void setRedisKeyPair() throws JsonProcessingException{
        redisHelper.set(String.valueOf("stock:finnhub:profile2:"+this.symbol), this.profileDTO);
    }

    @Override
    public ApiResp<List<SymbolDTO>> getSymbol() throws JsonProcessingException {
        return ApiResp.<List<SymbolDTO>>builder()
                        .code(Syscode.OK.getCode())
                        .message(Syscode.OK.getMessage())
                        .data(profileService.getSymbol().stream().map(e->DTOMapper.symbolDTOMapper(e)).toList())
                        .build();
    }

    @Override
    public ApiResp<List<String>> getSymbolList() throws JsonProcessingException {
        return ApiResp.<List<String>>builder()
                        .code(Syscode.OK.getCode())
                        .message(Syscode.OK.getMessage())
                        .data(this.getSymbol().getData().stream().filter(e->e.getType().equals("Common Stock") && e.getMic().equals("XNAS"))
                            .map(f->f.getSymbol()).toList())
                        .build();
    }




    
}
