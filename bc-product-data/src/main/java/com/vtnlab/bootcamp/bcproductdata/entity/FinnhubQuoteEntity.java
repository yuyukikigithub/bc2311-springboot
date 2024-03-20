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
@Table(name="texternal_stock_finnhub_quote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinnhubQuoteEntity implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate quote_date;
    private String quote_stock_code;
    private Double curr_price;
    private Double price_chg;
    private Double price_chg_pct;
    private Double price_day_high;
    private Double price_day_low;
    private Double price_prev_open;
    private Double price_prev_close;
    
}
