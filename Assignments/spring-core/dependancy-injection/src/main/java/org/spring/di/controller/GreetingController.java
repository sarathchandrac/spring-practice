package org.spring.di.controller;

import org.spring.di.service.HelloworldService;
import org.spring.di.service.HelloworldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingController {
    private HelloworldServiceImpl helloworldServiceImpl;

    @Autowired
    public GreetingController(HelloworldServiceImpl helloworldServiceImpl) {
        this.helloworldServiceImpl = helloworldServiceImpl;
    }

    public String sayHello() {
        String message  = helloworldServiceImpl.getGreeting();
        System.out.println(message);
        return message;

    }

}
