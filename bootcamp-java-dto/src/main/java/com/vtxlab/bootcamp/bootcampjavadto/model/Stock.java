package com.vtxlab.bootcamp.bootcampjavadto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {
    private String title;
    private double price;

    // Map<String, Double>
    // {
    //     "HSBC":5.5,
    //     "HSB":6.2
    // }
}
