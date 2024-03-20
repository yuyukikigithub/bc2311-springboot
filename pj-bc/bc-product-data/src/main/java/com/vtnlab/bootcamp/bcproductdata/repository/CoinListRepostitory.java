package com.vtnlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bcproductdata.entity.CoinListEntity;

@Repository
public interface CoinListRepostitory extends JpaRepository<CoinListEntity,Integer> {

    void deleteByCoinId(String coinId);
} 