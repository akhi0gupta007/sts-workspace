package com.basic.application.config.constants;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;

@Getter
public class JwtConfig {

	@Value("${security.jwt.uri:application/login/**}")
	private String Uri;

	@Value("${security.jwt.uri:/login}")
	private String microserviceLoginUri;

	@Value("${security.jwt.uri:application/createAuthentication/**}")
	private String microserviceCreateAuthenticationUri;

	@Value("${security.jwt.header:Authorization}")
	private String header;

	@Value("${security.jwt.prefix:Bearer }")
	private String prefix;

	@Value("${security.jwt.expiration:#{24*60*60}}")
	private int expiration;

	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;

}
