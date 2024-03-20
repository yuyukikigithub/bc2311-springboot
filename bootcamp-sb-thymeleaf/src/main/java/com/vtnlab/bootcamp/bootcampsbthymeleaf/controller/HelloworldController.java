package com.vtnlab.bootcamp.bootcampsbthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtnlab.bootcamp.bootcampsbthymeleaf.model.CoinData;
import com.vtnlab.bootcamp.bootcampsbthymeleaf.service.ApiService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(value = "/api/v1")
public class HelloworldController {

    @Autowired
    private ApiService apiService;
    
    @GetMapping(value="/hello")
    public String displayHelloPage(Model model) {
        model.addAttribute("greetingMessage","Hello world..");
        model.addAttribute("greetingMessage2", "ABCE");
        return "hello-world";
    }

    @GetMapping(value="/coin-data")
    public String displayCoinData(Model model) {
        List<CoinData> coinDatas = apiService.fetchData();
        model.addAttribute("coinDataList", coinDatas);
        // return model.toString();
        return "hello-world";
    }
    
}
