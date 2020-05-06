package org.spring.di;

import org.spring.di.controller.GreetingController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DependancyInjectionApplication {
	@Value("${welcome-message}")
	private String welcomeMsg;


	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(DependancyInjectionApplication.class, args);
		GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");
		greetingController.sayHello();

	}
	@Bean
	public CommandLineRunner commandLineTest(){
		return args -> System.out.println("args - " + welcomeMsg);

	}

}
