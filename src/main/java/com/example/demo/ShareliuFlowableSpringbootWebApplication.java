package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.extentions.AppDispatcherServletConfiguration;
import com.extentions.ApplicationConfiguration;
import com.extentions.DatabaseAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Import(value= {ApplicationConfiguration.class,AppDispatcherServletConfiguration.class,DatabaseAutoConfiguration.class})
public class ShareliuFlowableSpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareliuFlowableSpringbootWebApplication.class, args);
	}

}
