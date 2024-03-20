package com.vtnlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bcproductdata.entity.FinnhubQuoteEntity;

@Repository
public interface FinnhubQuoteRepository extends JpaRepository<FinnhubQuoteEntity,Long>{

    
} 