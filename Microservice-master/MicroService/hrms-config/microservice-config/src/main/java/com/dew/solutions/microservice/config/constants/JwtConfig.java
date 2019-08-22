package com.dew.solutions.microservice.config.constants;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

public class JwtConfig {

	@Getter
	@Value("${security.jwt.uri:application/login/**}")
	private String Uri;

	@Getter
	@Value("${security.jwt.uri:/login}")
	private String microserviceLoginUri;

	@Getter
	@Value("${security.jwt.uri:application/createAuthentication/**}")
	private String microserviceCreateAuthenticationUri;

	@Getter
	@Value("${security.jwt.header:Authorization}")
	private String header;

	@Getter
	@Value("${security.jwt.prefix:Bearer }")
	private String prefix;

	@Getter
	@Value("${security.jwt.expiration:#{24*60*60}}")
	private int expiration;

	@Getter
	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;

}
