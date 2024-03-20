package com.vtnlab.bootcamp.bcproductdata.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.StartListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewHomePage {
    @Autowired
    StockListRepository stockListRepository;

    // @GetMapping("path")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStock", stockListRepository.findAll());
        return "index";
    }
}
