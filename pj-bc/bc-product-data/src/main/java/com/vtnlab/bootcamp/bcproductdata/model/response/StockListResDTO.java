package com.vtnlab.bootcamp.bcproductdata.model.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StockListResDTO {
    List<String> stockList;
}
