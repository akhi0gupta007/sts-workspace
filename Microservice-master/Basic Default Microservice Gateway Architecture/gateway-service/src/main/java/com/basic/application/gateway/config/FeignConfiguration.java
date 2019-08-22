package com.basic.application.gateway.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;

import feign.Contract;
import feign.Request;
import feign.codec.Encoder;
import feign.form.FormEncoder;

@Configuration
public class FeignConfiguration {

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	public static Request.Options requestOptions(ConfigurableEnvironment env) {
		int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 100000);
		int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 90000);

		return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
	}

	@Bean
	public Contract useFeignAnnotations() {
		return new Contract.Default();
	}

	@Bean
	@Primary
	@Scope(scopeName = "prototype")
	Encoder feignFormEncoder() {
		return new FormEncoder(new SpringEncoder(this.messageConverters));
	}

}