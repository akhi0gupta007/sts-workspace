package com.basic.application.gateway.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "application")
public class GatewayController {

	private Logger logger = LoggerFactory.getLogger(GatewayController.class);

	@PostMapping("/**")
	public @ResponseBody ResponseEntity<?> gatewayEndpoint(HttpServletRequest request) {
		logger.info("request recieved at exposed controller");
		return ResponseEntity.ok(null);
	}
}