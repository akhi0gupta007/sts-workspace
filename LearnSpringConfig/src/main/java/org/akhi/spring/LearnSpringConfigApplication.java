package org.akhi.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class LearnSpringConfigApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringConfigApplication.class, args);
	}

}
