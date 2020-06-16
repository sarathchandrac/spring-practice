package com.example.mobileserviceclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MobileServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileServiceClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(){
        return args -> {
            System.err.println("Start Command line rurnner");
        };
    }
    @Bean
    public RestTemplate restTemplate(){

    }
}
