package com.vtnlab.bootcamp.bcproductdata.model;

import java.time.LocalDate;

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
public class CoinMarket {
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
    private LocalDate ath_date;
    private double atl;
    private double atl_change_percentage;
    private LocalDate atl_date;
    private RoiDTO roiDTO;
    private String last_updated; // quote_date

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RoiDTO{
        private double times;
        private String currency; // quote_currency
        private double percentage;
    }
}
