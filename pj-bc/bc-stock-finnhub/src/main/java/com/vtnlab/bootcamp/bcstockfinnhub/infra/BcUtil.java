package com.vtnlab.bootcamp.bcstockfinnhub.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
    public static String url(String path, String symbol ){
        // if (Symbol.getSymString(symbol.toLowerCase())==null) {
        //     throw new IllegalArgumentException("illegal symbol");
        // }
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://finnhub.io");
        builder.path("/api")
                .path("/v1");
        if (path.equals("quote")) {
            builder.path("/"+path);
            builder.queryParam("symbol", symbol.toUpperCase());
            builder.queryParam("token","cn9bgb1r01qoee99uv00cn9bgb1r01qoee99uv0g");

        }
        if (path.equals("stock")) {
            builder.path("/"+path);
            builder.path("/profile2");
            builder.queryParam("symbol", symbol.toUpperCase());
            builder.queryParam("token","cn9bgb1r01qoee99uv00cn9bgb1r01qoee99uv0g");

        }

        return builder.build().toUriString();
    }

    public static String urlSymbol(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://finnhub.io");

        builder.path("/api")
                .path("/v1")
                .path("/stock")
                .path("/symbol")
                .queryParam("exchange", "US")
                .queryParam("token","cn9bgb1r01qoee99uv00cn9bgb1r01qoee99uv0g");
        return builder.build().toUriString();
    }
}
