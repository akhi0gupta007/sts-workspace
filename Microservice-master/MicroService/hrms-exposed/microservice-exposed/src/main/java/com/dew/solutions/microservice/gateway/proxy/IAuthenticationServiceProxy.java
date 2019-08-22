package com.dew.solutions.microservice.gateway.proxy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import com.dew.solutions.microservice.config.configuration.FeignConfiguration;
import com.dew.solutions.microservice.config.exception.UserDoesNotExistException;

import feign.Headers;
import feign.RequestLine;

@FeignClient(name = "authentication-service", configuration = FeignConfiguration.class)
@Qualifier(value = "authenticationServiceProxy")
public interface IAuthenticationServiceProxy {

	@RequestLine("POST /login")
	@Headers("Content-Type: application/json")
	public ResponseEntity<?> login(Map<String, ?> requestInformation) throws UserDoesNotExistException;

	@RequestLine("POST /createAuthentication")
	@Headers("Content-Type: application/json")
	public ResponseEntity<?> createAuthentication(Map<String, ?> requestInformation);

}