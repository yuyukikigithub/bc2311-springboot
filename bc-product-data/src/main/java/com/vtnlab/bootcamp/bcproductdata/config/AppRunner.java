package com.vtnlab.bootcamp.bcproductdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bcproductdata.repository.CoinListRepostitory;
import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.FixedRateService;
import com.vtnlab.bootcamp.bcproductdata.service.StartListService;


@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    CoinListRepostitory coinListRepostitory;

    @Autowired
    StockListRepository stockListRepository;

    @Autowired
    StartListService startListService;

    @Autowired
    FixedRateService fixedRateService;

    @Override
    public void run(String... args) throws Exception {
        if (coinListRepostitory.findAll().size()==0 && stockListRepository.findAll().size()==0) {
            // System.out.println("hello form runner");
            startListService.saveCoinList();
            startListService.saveStockList();
            
        }
        
    }



    
}
