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
    private double c;
    private double d;
    private double dp;
    private double h;
    private double l;
    private double o;
    private double pc;
    private double t;
}
