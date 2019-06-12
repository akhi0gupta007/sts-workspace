package org.akhi.spring.web;

import org.akhi.spring.config.Configuration;
import org.akhi.spring.model.ConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class ConfigTestController {


	@Autowired
	private Configuration config;

	@RequestMapping("/testConfig")	
	public ConfigModel getConfig(){
		return new ConfigModel(config.getMaximum(), config.getMinimum());
	}
	
	@HystrixCommand(fallbackMethod = "fallBackMethod")
	@GetMapping("/fault-example")
	public ConfigModel retrieveConfig() {
		throw new RuntimeException("Not available");
	}
	
	
	public ConfigModel fallBackMethod() {
		return new ConfigModel(9,999);		
	}

}
