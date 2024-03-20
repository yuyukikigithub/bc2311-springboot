package com.vtnlab.bootcamp.bccryptocoingecko.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinsMarketsModel {

    private String id;
    private String symbol; // quote_coin_code
    private String name;
    private String image;
    private double current_price; // curr_price
    private Long market_cap;
    private Long market_cap_rank;
    private Long fully_diluted_valuation;
    private Long total_volume;
    private double high_24h;
    private double low_24h;
    private double price_change_24h;
    private double price_change_percentage_24h;
    private double market_cap_change_24h;
    private double market_cap_change_percentage_24h;
    private double circulating_supply;
    private double total_supply;
    private double max_supply;
    private double ath;
    private double ath_change_percentage;
    private String ath_date;
    private double atl;
    private double atl_change_percentage;
    private String atl_date;
    private Roi roi;
    private String last_updated; // quote_date

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Roi{
        private double times;
        private String currency; // quote_currency
        private double percentage;
    }

}
