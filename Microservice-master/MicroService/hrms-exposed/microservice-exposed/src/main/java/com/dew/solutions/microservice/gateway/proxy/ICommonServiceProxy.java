package com.dew.solutions.microservice.gateway.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.dew.solutions.microservice.config.configuration.FeignConfiguration;
import com.dew.solutions.microservice.config.exception.ServiceException;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@FeignClient(name = "common-service", configuration = FeignConfiguration.class)
@Qualifier(value = "commonServiceProxy")
public interface ICommonServiceProxy extends IBasicCrudServiceProxy {

	@Override
	@Headers("Authorization: {accessToken}")
	@RequestLine("GET /{entity}/get/{id}")
	ResponseEntity<?> getById(@Param(value = "accessToken") String token, @Param(value = "entity") final String entity,
			@Param(value = "id") final Long id) throws ServiceException;

	@Override
	@Headers("Authorization: {accessToken}")
	@RequestLine("GET /{entity}/getAll")
	ResponseEntity<?> getAll(@Param(value = "accessToken") String token, @Param(value = "entity") final String entity)
			throws ServiceException;

	@Override
	@Headers("Authorization: {accessToken}")
	@RequestLine("GET /{entity}/remove/{id}")
	ResponseEntity<?> removeById(@Param(value = "accessToken") String token,
			@Param(value = "entity") final String entity, @Param(value = "id") final Long id) throws ServiceException;

	@Override
	@Headers("Authorization: {accessToken}")
	@RequestLine("POST /{entity}/saveOrUpdate")
	ResponseEntity<?> saveOrUpdate(@Param(value = "accessToken") String token,
			@Param(value = "entity") final String entity, @RequestBody Object obj) throws ServiceException;

}
