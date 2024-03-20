package com.vtnlab.bootcamp.bcproductdata.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StockListReqDTO {
    String syscode;
    String message;
    List<String> data;
}
