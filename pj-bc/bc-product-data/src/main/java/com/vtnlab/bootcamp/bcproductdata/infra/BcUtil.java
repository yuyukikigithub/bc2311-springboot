package com.vtnlab.bootcamp.bcproductdata.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
    public static String urlCoinGecko (){
        return UriComponentsBuilder.fromUriString("http://localhost:8090/crypto/coingecko/api/v1/coins/markets?vs_currency=usd")
                .toUriString();
    }

    public static String urlCoinGeckoMarket (String coin){
        return UriComponentsBuilder.fromUriString("http://localhost:8090/crypto/coingecko/api/v1/coins?vs_currency=usd&ids="+coin)
                .toUriString();
    }

    public static String urlFinnhubProfile (){
        return UriComponentsBuilder.fromUriString("http://localhost:8091/stock/finnhub/api/v1/profile2/symbolList")
                .toUriString();
    }

    public static String urlFinnhubProfile2 (String symbol){
        return UriComponentsBuilder.fromUriString("http://localhost:8091/stock/finnhub/api/v1/profile2?symbol="+symbol)
                .toUriString();
    }

    public static String urlFinnhubQuote (){
        return UriComponentsBuilder.fromUriString("http://localhost:8091/stock/finnhub/api/v1/quote?symbol=aapl")
                .toUriString();
    }
}
