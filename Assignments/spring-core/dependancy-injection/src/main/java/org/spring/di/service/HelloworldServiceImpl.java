package org.spring.di.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HelloworldServiceImpl implements HelloworldService, InitializingBean, DisposableBean {

    @Override
    public String getGreeting() {
        return "Hello World!";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable Bean method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean --> after properties set");

    }

    @PostConstruct
    public void afterConstructorExecution() {
        System.out.println("@PostConstruct");
    }
    @PreDestroy
    public void beforeDestruction(){
        System.out.println("@PreDestroy destroy...");
    }
}
