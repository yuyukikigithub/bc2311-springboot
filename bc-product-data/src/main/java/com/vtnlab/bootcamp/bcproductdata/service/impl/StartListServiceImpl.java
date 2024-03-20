package com.vtnlab.bootcamp.bcproductdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcproductdata.entity.CoinListEntity;
import com.vtnlab.bootcamp.bcproductdata.entity.StockListEntity;
import com.vtnlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtnlab.bootcamp.bcproductdata.model.request.CoinListReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.request.StockListReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.CoinListResDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.StockListResDTO;
import com.vtnlab.bootcamp.bcproductdata.repository.CoinListRepostitory;
import com.vtnlab.bootcamp.bcproductdata.repository.StockListRepository;
import com.vtnlab.bootcamp.bcproductdata.service.StartListService;

@Service
public class StartListServiceImpl implements StartListService {

    @Autowired
    StockListRepository stockListRepository;

    @Autowired
    CoinListRepostitory coinListRepostitory;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean saveCoinList() {
        CoinListReqDTO coinListReqDto = restTemplate.getForObject(BcUtil.urlCoinGecko(), CoinListReqDTO.class);
        coinListReqDto.getData().stream().map(e->CoinListEntity.builder().coinId(e).build()).limit(20).forEach(coinListRepostitory::save);
        return true;

    }

    @Override
    public boolean saveStockList() {
        StockListReqDTO stockListReqDTO = restTemplate.getForObject(BcUtil.urlFinnhubProfile(), StockListReqDTO.class);
        stockListReqDTO.getData().stream().map(e->StockListEntity.builder().stockId(e).build()).limit(20).forEach(stockListRepository::save);
        return true;
    }

    @Override
    public boolean deleteCoin(String coinId) {
        coinListRepostitory.deleteByCoinId(coinId);
        return true;
    }

    @Override
    public boolean deleteStock(String stockId) {
        stockListRepository.deleteByStockId(stockId);
        return true;
    }

    @Override
    public CoinListResDTO getCoinList() {
        List<String> coinList = coinListRepostitory.findAll().stream().map(e -> e.getCoinId()).toList();
        System.out.println(coinList);
        return CoinListResDTO.builder().coinList(coinList).build();
    }

    // @Override
    // public List<String> getCoinListTry() {
    //     List<String> coinList = restTemplate.getForObject(BcUtil.urlCoinGecko(), null);
    // }

    @Override
    public StockListResDTO getStockList() {
        List<String> stockList = stockListRepository.findAll().stream().map(e->e.getStockId()).toList();
        return StockListResDTO.builder().stockList(stockList).build();
    }

    @Override
    public boolean deleteAll() {
        coinListRepostitory.deleteAll();
        stockListRepository.deleteAll();
        return true;
    }

    
    
}
