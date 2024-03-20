package com.vtnlab.bootcamp.bcproductdata.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinListReqDTO {
    String syscode;
    String message;
    List<String> data;
}
