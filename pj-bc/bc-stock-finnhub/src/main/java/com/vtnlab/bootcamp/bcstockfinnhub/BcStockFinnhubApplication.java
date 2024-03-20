package com.vtnlab.bootcamp.bcstockfinnhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BcStockFinnhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcStockFinnhubApplication.class, args);
	}

}
