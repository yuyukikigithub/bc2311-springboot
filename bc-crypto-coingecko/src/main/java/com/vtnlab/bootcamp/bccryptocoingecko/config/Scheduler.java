package com.vtnlab.bootcamp.bccryptocoingecko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bccryptocoingecko.infra.RedisHelper;

// @Component

public class Scheduler {
    
    // @Autowired
    // private RedisHelper redisHelper;

    // @Scheduled(fixedRate=5000)
    // public void setRedisKeyPair(String key, Object value) throws JsonProcessingException{
    //     redisHelper.set(key, value);
    // }

}
