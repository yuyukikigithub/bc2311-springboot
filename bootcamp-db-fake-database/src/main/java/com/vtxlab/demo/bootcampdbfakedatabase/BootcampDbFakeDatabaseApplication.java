package com.vtxlab.demo.bootcampdbfakedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//=  @ComponentScan (RestController, new DatabaseController) + @SpringBootConfiguration + @EnableAutoConfiguration
public class BootcampDbFakeDatabaseApplication {
	private static ConfigurableApplicationContext cac;

	public static ConfigurableApplicationContext getSpringContext(){
		return cac;
	}

	public static void main(String[] args) {
		// run when get in
		System.out.println("start fake database");
		//Spring context
		cac=SpringApplication.run(BootcampDbFakeDatabaseApplication.class, args);
		String[] beans=cac.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println("beans = "+bean);
		}
		System.out.println("end fake database");
	}

}
