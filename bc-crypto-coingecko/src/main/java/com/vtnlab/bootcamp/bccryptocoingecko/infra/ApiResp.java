package com.vtnlab.bootcamp.bccryptocoingecko.infra;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
// @JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResp<T> {
    private String code;
    private String message;
    private T data;
}
