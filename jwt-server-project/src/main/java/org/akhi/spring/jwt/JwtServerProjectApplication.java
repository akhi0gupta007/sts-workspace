package org.akhi.spring.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.akhi.spring"})
public class JwtServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtServerProjectApplication.class, args);
	}

}
