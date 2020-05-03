package org.spring.core.security.sercurity_service;

import org.spring.core.security.sercurity_service.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
        TestService testService = (TestService) ctx.getBean("testService");
        testService.test();
    }
}
