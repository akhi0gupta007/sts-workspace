package com.dew.solutions.microservice.authentication.service;

import java.util.Map;

import com.dew.solutions.microservice.config.dto.AuthenticationEntityDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface IAuthenticationService extends IGenericService<AuthenticationEntityDto, Long> {

	public boolean createAuthentication(Map<String, Object> requestObject) throws ServiceException;

}
