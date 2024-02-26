package com.vtnlab.bootcamp.bcstockfinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Profile {
    private String country;
    private String currency;
    private String estimateCurrency;
    private String exchange;
    private String finnhubIndustry;
    private String ipo;
    private String logo;
    private double marketCapitalization;
    private String name;
    private double shareOutstanding;
    private String ticker;
    private String weburl;
    
    
}
