package com.vtnlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bcproductdata.entity.StockListEntity;

@Repository
public interface StockListRepository extends JpaRepository<StockListEntity,Integer>{

    void deleteByStockId(String stockId);
} 
