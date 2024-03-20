package com.vtnlab.bootcamp.bcproductdata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtnlab.bootcamp.bcproductdata.entity.StockListEntity;
import com.vtnlab.bootcamp.bcproductdata.model.response.CoinListResDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.StockListResDTO;

public interface StartListOperation {

    @GetMapping("/coin")
    CoinListResDTO getCoinList();

    @GetMapping("/saveall")
    void saveAllList();

    @GetMapping("/stock")
    StockListResDTO getStockList();

    @GetMapping("/stockEntity")
    List<StockListEntity> getStockListEntity();

    @DeleteMapping("/coin")
    boolean deleteCoin(String coinId);

    @DeleteMapping("/stock")
    boolean deleteStock(String stockId);

    // save to 
    @GetMapping("/saveCoinMarket")
    boolean saveCoinMarket(@RequestParam(value = "coin") String coin);
    
    @GetMapping("/saveProfile")
    boolean saveProfile(@RequestParam(value = "symbol") String symbol);


    @GetMapping("/saveAllProfile")
    List<Boolean> saveAllProfile();

    @GetMapping("/saveAllCoin")
    List<Boolean> saveAllCoin();


}
