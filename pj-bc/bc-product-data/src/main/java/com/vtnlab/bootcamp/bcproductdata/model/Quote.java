package com.vtnlab.bootcamp.bcproductdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {
    private Double c; // current_price
    private Double d; // Change
    private Double dp;// percent change
    private Double h; // price_day_high
    private Double l; // price_day_low
    private Double o; // open price of day
    private Double pc; // previous close price
    private Long t;
}
