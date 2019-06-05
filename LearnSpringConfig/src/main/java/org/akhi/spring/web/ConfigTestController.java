package org.akhi.spring.web;

import org.akhi.spring.config.Configuration;
import org.akhi.spring.model.ConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {


	@Autowired
	private Configuration config;

	@RequestMapping("/testConfig")
	public ConfigModel getConfig(){
		return new ConfigModel(config.getMaximum(), config.getMinimum());
	}

}
