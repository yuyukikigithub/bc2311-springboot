package com.vtnlab.bootcamp.bcproductdata.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bcproductdata.entity.CoingeckoMarketEntity;
import com.vtnlab.bootcamp.bcproductdata.repository.CoinListRepostitory;
import com.vtnlab.bootcamp.bcproductdata.repository.CoingeckoMarketRepository;
import com.vtnlab.bootcamp.bcproductdata.repository.FinnhubProfile2Repository;
import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.FixedRateService;

@Component
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    FixedRateService fixedRateService;

    @Autowired
    CoinListRepostitory coinListRepostitory;

    @Autowired
    CoingeckoMarketRepository coingeckoMarketRepository;

    @Autowired
    StockListRepository stockListRepostitory;

    @Autowired
    FinnhubProfile2Repository finnhubProfile2Repository;
    
    // @Scheduled(fixedRate = 120000)
    public void saveQuotePerMin()throws InterruptedException {
        fixedRateService.saveQuote();
        System.out.println("saving quote");
    }
    @Scheduled(fixedRate = 120000)
    public void saveCoinPerMin()throws InterruptedException {
        coingeckoMarketRepository.deleteAll();
        coinListRepostitory.findAll().stream().map(e->fixedRateService.saveCoinMarket(e.getCoinId())).toList();
        System.out.println(coinListRepostitory.findAll());
    }
    @Scheduled(fixedRate = 120000)
    public void saveProfilePerMin()throws InterruptedException {
        finnhubProfile2Repository.deleteAll();
        stockListRepostitory.findAll().stream().map(e->fixedRateService.saveProfile2(e.getStockId())).toList();
        System.out.println(stockListRepostitory.findAll());
        
    }
}
