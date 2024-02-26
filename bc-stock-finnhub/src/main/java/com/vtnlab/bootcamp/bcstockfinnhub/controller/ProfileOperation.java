package com.vtnlab.bootcamp.bcstockfinnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.ProfileDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.ApiResp;

public interface ProfileOperation {
    @GetMapping(value="")
    ApiResp<ProfileDTO> getProfile(@RequestParam String symbol) throws JsonProcessingException;
}
