package com.vtnlab.bootcamp.bcproductdata.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.vtnlab.bootcamp.bcproductdata.entity.StockListEntity;
import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.StartListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ViewHomePage {
    @Autowired
    StockListRepository stockListRepository;

    // @GetMapping("path")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    // @GetMapping("/stocklist")

    @RequestMapping(value="/", method =RequestMethod.GET)
    public String viewHomePage(Model model) {
        
        return "index";
    }

    @RequestMapping(value="/addstocklist", method=RequestMethod.GET)
    public String addStockList(Model model) {
        StockListEntity stockListEntity = new StockListEntity();
        model.addAttribute("stockListEntity", stockListEntity);
        return "addstocklist";
    }

    @RequestMapping(value="/addstocklist", method=RequestMethod.POST)
    public String postStockList(@ModelAttribute("stockListEntity")StockListEntity stockListEntity ) {
        stockListRepository.save(stockListEntity);
        return "stocklist_success";
    }

    @RequestMapping({"/stocklist"})
    public String viewStockList(Model model) {
        model.addAttribute("listStock", stockListRepository.findAll());
        return "stock";
    }

    @ModelAttribute("stockstocklist")
    public List<StockListEntity> getStockList(){
        List<StockListEntity> list = new ArrayList<>();
        // list.add(new StockListEntity(1,"gugu"));
        // list.add(new StockListEntity(2,"lulu"));
        stockListRepository.findAll().stream().map(e->list.add(e));
        return list;
    }
}
