package com.vtxlab.demo.bootcampdbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Simulate actual process of "mvn spring-boot:run"
// trigger @SpringBootTest, we use "mvn clean test"
// simulate running SpringApplication.run at "mvn clean test"
// testing @SpringBootApplication -> @ComponentScan + @Autowired
// just try the dependency of whole programme
class BootcampDbFakeDatabaseApplicationTests {

	// in @SpringBootTest env, 
	// spring context will contain all your custom beans
	// e.g. @Controller, @Service, @Configuation, @Bean
	

	@Test // at least one @Test to start up the test env @SpringBootTest
	void contextLoads() {
	}

}
