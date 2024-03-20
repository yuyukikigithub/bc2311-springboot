package com.vtnlab.bootcamp.bcproductdata.model.request;

import java.util.List;

import com.vtnlab.bootcamp.bcproductdata.model.CoinMarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinMarketReqDTO {
    private String code;
    private String message;
    private List<CoinMarket> data; 
    
}
