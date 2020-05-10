package org.spring.dl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationLoggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLoggingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineTest(){
		//return args -> System.out.println("args --> " + welcomeMsg);
		return args -> {
			System.out.println("args --> " + welcomeMsg);
			
			loggerInfo();
		};
	}
	public void loggerInfo() {
		logger.debug("Debug - Message is printed");
		logger.trace("TRACE - Message is printed");
		logger.info("INFO - Message is printed");
		logger.error("ERROR - Message is printed");
		logger.warn("WARNING - Message is printed");
	}
	public void readEnvironmentInfo() {
		System.out.println("Environment - path ---> " + environment.getProperty("path"));
		System.out.println("Environment - welcomeMsg ---> " + environment.getProperty("welcome-message"));
	}

}
