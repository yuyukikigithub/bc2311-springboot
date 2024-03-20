package com.vtnlab.bootcamp.bcproductdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtnlab.bootcamp.bcproductdata.model.request.CoinListReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.request.StockListReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.CoinListResDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.StockListResDTO;


public interface StartListService {
    
    boolean saveCoinList();

    boolean saveStockList();
  
    boolean deleteCoin(String coinId);
  
    boolean deleteStock(String stockId);

    public CoinListResDTO getCoinList();

    // public List<String> getCoinListTry();

    public StockListResDTO getStockList();

    boolean deleteAll();
}
