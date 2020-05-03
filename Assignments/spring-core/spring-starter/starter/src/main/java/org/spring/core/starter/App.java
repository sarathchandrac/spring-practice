package org.spring.core.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
    	TestBean bean = (TestBean) ctx.getBean("testBean");
    	//HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
    	bean.sayHello();
        //System.out.println( "Hello World!" );
    }
}
