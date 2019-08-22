package com.dew.solutions.microservice.gateway.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dew.solutions.microservice.config.exception.ServiceException;

public interface IGatewayService {

	public Object saveOrUpdate(Map<String, ?> requestInformation) throws ServiceException;

	public Object action(Map<String, ?> requestInformation);

	public Object getById(Map<String, ?> requestInformation) throws ServiceException;

	public Object getAll(Map<String, ?> requestInformation) throws ServiceException;

	public Object removeById(Map<String, ?> requestInformation) throws ServiceException;

}
