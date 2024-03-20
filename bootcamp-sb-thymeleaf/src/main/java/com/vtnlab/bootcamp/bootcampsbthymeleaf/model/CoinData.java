package com.vtnlab.bootcamp.bootcampsbthymeleaf.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CoinData {
    private String id;
    private String image;
    @JsonProperty(value="currentPrice")
    private Double current_price;

}
