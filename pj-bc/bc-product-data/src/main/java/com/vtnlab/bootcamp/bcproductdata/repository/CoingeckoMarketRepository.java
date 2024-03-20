package com.vtnlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bcproductdata.entity.CoingeckoMarketEntity;

@Repository
public interface CoingeckoMarketRepository extends JpaRepository<CoingeckoMarketEntity,Long>{

    
} 