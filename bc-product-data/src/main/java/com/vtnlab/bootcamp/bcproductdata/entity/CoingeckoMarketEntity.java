package com.vtnlab.bootcamp.bcproductdata.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="texternal_crypto_coingecko_market")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoingeckoMarketEntity implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate quote_date; 
    private String quote_coin_code; //symbol
    private String quote_currency; //roi_currency
    private String name; //v
    private String image; //v
    private Double curr_price; //v
    private Long market_cap; //v
    private Long market_cap_rank; //v
    private Long fully_diluted_valuation; //v
    private Long total_volume; //v
    private Double high_24h; //v
    private Double low_24h; //v
    private Double price_change_24h; //v
    private Double price_change_pct_24h; //v
    private Double market_cap_change_24h; //v
    private Double market_cap_change_pct_24h; //v
    private Double circulating_supply; //v
    private Double total_supply; //v
    private Double max_supply; //v
    private Double ath; //v
    private Double ath_change_percentage; //v
    private LocalDate ath_date; //v
    private Double atl; //v
    private Double atl_change_percentage; //v
    private LocalDate atl_date; //v
    
}
