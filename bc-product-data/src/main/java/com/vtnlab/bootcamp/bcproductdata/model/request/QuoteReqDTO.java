package com.vtnlab.bootcamp.bcproductdata.model.request;

import com.vtnlab.bootcamp.bcproductdata.model.Quote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class QuoteReqDTO {
    String syscode;
    String message;
    Quote data;
}
