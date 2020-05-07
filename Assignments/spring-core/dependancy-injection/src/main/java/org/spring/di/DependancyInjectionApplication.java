package org.spring.di;

import org.spring.di.configuration.MailConfig;
import org.spring.di.controller.GreetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("application-configuration.properties")
public class DependancyInjectionApplication {
	@Value("${welcome-message}")
	private String welcomeMsg;
	
	@Autowired
	private Environment environment;
	
	// Configuration Test
	@Autowired
	private MailConfig mailProperties;


	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(DependancyInjectionApplication.class, args);
		GreetingController greetingController = (GreetingController) ctx.getBean("greetingController");
		greetingController.sayHello();

	}
	@Bean
	public CommandLineRunner commandLineTest(){
		//return args -> System.out.println("args --> " + welcomeMsg);
		return args -> {
			System.out.println("args --> " + welcomeMsg);
			System.out.println("args --> " + mailProperties);
			mailProperties.getDefaultReciepients().forEach(System.out::println);
			readEnvironmentInfo();
		};
	}
	
	public void readEnvironmentInfo() {
		System.out.println("Environnet - path ---> " + environment.getProperty("path"));
	}

}
