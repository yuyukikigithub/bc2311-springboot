package com.vtnlab.bootcamp.bccryptocoingecko.infra;

import org.springframework.web.util.UriComponentsBuilder;


public class BcUtil {
    public static String idUrl(Scheme scheme, String domain, String endpoint){
        return UriComponentsBuilder.newInstance()
        .scheme(scheme.lowercaseName())
        .host(domain)
        .path(endpoint)
        .toUriString();

    }

    public static String coinsUrl(String currency, String ids){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://api.coingecko.com");
        builder.path("/api");
        builder.path("/v3");
        builder.path("/coins");
        builder.path("/markets");
        builder.queryParam("vs_currency", currency);
        builder.queryParam("ids", ids);
        builder.queryParam("x_cg_demo_api_key", "CG-hjGZ41gYarFDB5K9a5Q2n487");

        return builder.build().toUriString();
    }

    public static String coinsUrlAllIds(String currency){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://api.coingecko.com");
        builder.path("/api");
        builder.path("/v3");
        builder.path("/coins");
        builder.path("/markets");
        builder.queryParam("vs_currency", currency);
        builder.queryParam("x_cg_demo_api_key", "CG-hjGZ41gYarFDB5K9a5Q2n487");

        return builder.build().toUriString();
    }
}
