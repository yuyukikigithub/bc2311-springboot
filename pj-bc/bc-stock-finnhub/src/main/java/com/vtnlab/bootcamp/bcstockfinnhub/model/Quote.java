package com.vtnlab.bootcamp.bcstockfinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quote {
    private double c; // current_price
    private double d; // Change
    private double dp;// percent change
    private double h; // price_day_high
    private double l; // price_day_low
    private double o; // open price of day
    private double pc; // previous close price
    private long t; // timestamp
}
