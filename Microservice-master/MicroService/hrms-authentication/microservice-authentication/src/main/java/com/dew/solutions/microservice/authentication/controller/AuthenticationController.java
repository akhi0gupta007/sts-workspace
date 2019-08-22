package com.dew.solutions.microservice.authentication.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.authentication.service.IAuthenticationService;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.util.Utility;

@RestController
public class AuthenticationController {

	@Autowired
	private IAuthenticationService iAuthenticationService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> loginSuccess(HttpServletRequest request, @RequestBody Map<String, Object> requestObject) {
		return ResponseEntity.ok(Utility.sendSuccessResponse("Login Success", "login", "success"));

	}

	@PostMapping(value = "/createAuthentication")
	public ResponseEntity<?> createAuthentication(HttpServletRequest request,
			@RequestBody Map<String, Object> requestObject) {
		try {
			return ResponseEntity.ok(Utility.sendSuccessResponse("Authentication Created Successfully", "userCreation",
					iAuthenticationService.createAuthentication(requestObject)));
		} catch (ServiceException e) {
			return ResponseEntity.ok(Utility.sendFailureResponse(e));

		}
	}
}
