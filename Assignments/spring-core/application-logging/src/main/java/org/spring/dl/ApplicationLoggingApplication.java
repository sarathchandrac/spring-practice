package org.spring.dl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ApplicationLoggingApplication {
	@Value("${welcome-message}")
	private String welcomeMsg;
	
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLoggingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineTest(){
		//return args -> System.out.println("args --> " + welcomeMsg);
		return args -> {
			System.out.println("args --> " + welcomeMsg);
			
			readEnvironmentInfo();
		};
	}
	public void readEnvironmentInfo() {
		System.out.println("Environment - path ---> " + environment.getProperty("path"));
		System.out.println("Environment - welcomeMsg ---> " + environment.getProperty("welcome-message"));
	}

}
