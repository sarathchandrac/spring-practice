package com.example.demo;

import com.example.demo.filter.MeasureProcessingTimeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<MeasureProcessingTimeFilter> registerLogProcesingTimeFilter(){
		FilterRegistrationBean<MeasureProcessingTimeFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new MeasureProcessingTimeFilter());
		filterFilterRegistrationBean.addUrlPatterns("/*");
		return filterFilterRegistrationBean;
	}

}
