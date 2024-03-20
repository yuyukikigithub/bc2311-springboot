package com.vtnlab.bootcamp.bootcampsbforum.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtnlab.bootcamp.bootcampsbforum.model.User2;

public interface RedisService {
    User2 createUser2(String key, User2 user) throws JsonProcessingException;

    User2 getUser2(String key) throws JsonProcessingException;
    
} 
