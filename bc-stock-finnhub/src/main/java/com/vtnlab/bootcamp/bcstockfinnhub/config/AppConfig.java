package com.vtnlab.bootcamp.bcstockfinnhub.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.ProfileDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.dto.QuoteDTO;
import com.vtnlab.bootcamp.bcstockfinnhub.infra.RedisHelper;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;

@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    RedisHelper redisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper){
        return new RedisHelper(factory, objectMapper);
    }
    


}
