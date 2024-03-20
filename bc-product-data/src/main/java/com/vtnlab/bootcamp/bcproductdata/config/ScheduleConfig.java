package com.vtnlab.bootcamp.bcproductdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bcproductdata.service.FixedRateService;

@Component
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    FixedRateService fixedRateService;
    
    // @Scheduled(fixedRate = 120000)
    public void saveQuotePerMin()throws InterruptedException {
        fixedRateService.saveQuote();
        System.out.println("saving quote");
    }
}
