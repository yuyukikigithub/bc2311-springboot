package com.vtnlab.bootcamp.bcproductdata.model.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CoinListResDTO {
    List<String> coinList;
}
