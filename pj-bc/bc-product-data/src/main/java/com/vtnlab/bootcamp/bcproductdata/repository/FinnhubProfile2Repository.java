package com.vtnlab.bootcamp.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtnlab.bootcamp.bcproductdata.entity.FinnhubProfile2Entity;

@Repository
public interface FinnhubProfile2Repository extends JpaRepository<FinnhubProfile2Entity,Long>{

    
} 
