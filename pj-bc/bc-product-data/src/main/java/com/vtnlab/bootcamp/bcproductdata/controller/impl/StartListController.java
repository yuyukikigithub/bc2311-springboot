package com.vtnlab.bootcamp.bcproductdata.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtnlab.bootcamp.bcproductdata.controller.StartListOperation;
import com.vtnlab.bootcamp.bcproductdata.entity.StockListEntity;
import com.vtnlab.bootcamp.bcproductdata.model.response.CoinListResDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.StockListResDTO;
import com.vtnlab.bootcamp.bcproductdata.repository.CoinListRepostitory;
import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.FixedRateService;
import com.vtnlab.bootcamp.bcproductdata.service.StartListService;

@RestController
@RequestMapping("/admin")

public class StartListController implements StartListOperation {

    
    @Autowired
    CoinListRepostitory coinListRepostitory;

    @Autowired
    StockListRepository stockListRepository;

    @Autowired
    StartListService startListService;

    @Autowired
    FixedRateService fixedRateService;
    

    @Override
    public CoinListResDTO getCoinList() {
        return startListService.getCoinList();
    }

    @Override
    public void saveAllList() {
        if (coinListRepostitory.findAll().size()==0 && stockListRepository.findAll().size()==0){
            startListService.saveCoinList();
            startListService.saveStockList();
        }
    }

    @Override
    public StockListResDTO getStockList() {
        return startListService.getStockList();
    }

    @Override
    public List<StockListEntity> getStockListEntity() {
        return stockListRepository.findAll();
    }

    @Override
    public boolean deleteCoin(String coinId) {
        return startListService.deleteCoin(coinId);
    }

    @Override
    public boolean deleteStock(String stockId) {
        return startListService.deleteStock(stockId);
    }

    @Override
    public boolean saveCoinMarket(String coin) {
        return fixedRateService.saveCoinMarket(coin);
    }

    @Override
    public boolean saveProfile(String symbol) {
        return fixedRateService.saveProfile2(symbol);
    }

    @Override
    public List<Boolean> saveAllProfile() {
        StockListResDTO tempDTO = this.getStockList();
        List<Boolean> boo = tempDTO.getStockList().stream().filter(e->e!=null).map(e->this.saveProfile(e)).toList();
        return boo;
    }

    @Override
    public List<Boolean> saveAllCoin() {
        CoinListResDTO coinListResDTO = startListService.getCoinList();
        List<Boolean> boo = coinListResDTO.getCoinList().stream().filter(e->e!=null).map(e->this.saveCoinMarket(e)).toList();
        return boo;

    }

    


    

    
    
}
