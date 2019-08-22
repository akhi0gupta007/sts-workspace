package com.dew.solutions.microservice.config.configuration;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapper {

	@Bean
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() throws Exception {

		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		return dozerBeanMapperFactoryBean;
	}

}
