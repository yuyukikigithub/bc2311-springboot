package com.vtnlab.bootcamp.bcproductdata.service;

public interface FixedRateService {

    boolean saveQuote();

    boolean saveCoinMarket(String coin);

    boolean saveProfile2(String symbol);
}
