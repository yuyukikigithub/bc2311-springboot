package com.vtnlab.bootcamp.bootcampsbforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bootcampsbforum.infra.RedisHelper;
import com.vtnlab.bootcamp.bootcampsbforum.model.User2;
import com.vtnlab.bootcamp.bootcampsbforum.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisHelper redisHelper;

    @Override
    public User2 createUser2(String key, User2 user) throws JsonProcessingException {
        redisHelper.set(key, user);
        return user;
    }

    @Override
    public User2 getUser2(String key) throws JsonProcessingException {
        return redisHelper.get(key, User2.class);
    }
    
}
