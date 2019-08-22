package com.dew.solutions.microservice.gateway.service.impl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.RequestParams;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.exception.UserDoesNotExistException;
import com.dew.solutions.microservice.gateway.proxy.IAuthenticationServiceProxy;
import com.dew.solutions.microservice.gateway.proxy.IBasicCrudServiceProxy;
import com.dew.solutions.microservice.gateway.service.IGatewayService;

@Service
public class GatewayServiceImpl implements IGatewayService {

	@Override
	public Object action(Map<String, ?> requestInformation) {
		ResponseEntity<?> response = null;

		// TODO need to change to proper error handling
		try {
			if (requestInformation.get("roles") != null) {
				response = ((IAuthenticationServiceProxy) requestInformation.get("proxy"))
						.createAuthentication(requestInformation);
				return response.getBody();
			}
			response = ((IAuthenticationServiceProxy) requestInformation.get("proxy")).login(requestInformation);
			return response;
		} catch (UserDoesNotExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getById(Map<String, ?> requestInformation) throws ServiceException {
		ResponseEntity<?> response = null;

		try {
			response = ((IBasicCrudServiceProxy) requestInformation.get("proxy")).getById(
					(String) requestInformation.get(RequestParams.AUTHORIZATION_HEADER),
					(String) requestInformation.get(ParsedRequestData.SERVICE_TYPE),
					(Long) requestInformation.get("id"));
			System.out.println(response);
			return response.getBody();
		} catch (UserDoesNotExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getAll(Map<String, ?> requestInformation) throws ServiceException {
		ResponseEntity<?> response = null;

		try {
			response = ((IBasicCrudServiceProxy) requestInformation.get("proxy")).getAll(
					(String) requestInformation.get(RequestParams.AUTHORIZATION_HEADER),
					(String) requestInformation.get(ParsedRequestData.SERVICE_TYPE));
			System.out.println(response);
			return response.getBody();
		} catch (UserDoesNotExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object removeById(Map<String, ?> requestInformation) throws ServiceException {
		ResponseEntity<?> response = null;

		try {
			response = ((IBasicCrudServiceProxy) requestInformation.get("proxy")).removeById(
					(String) requestInformation.get(RequestParams.AUTHORIZATION_HEADER),
					(String) requestInformation.get(ParsedRequestData.SERVICE_TYPE),
					(Long) requestInformation.get("id"));
			System.out.println(response);
			return response;
		} catch (UserDoesNotExistException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object saveOrUpdate(Map<String, ?> requestInformation) throws ServiceException {
		ResponseEntity<?> response = null;

		try {
			response = ((IBasicCrudServiceProxy) requestInformation.get("proxy")).saveOrUpdate(
					(String) requestInformation.get(RequestParams.AUTHORIZATION_HEADER),
					(String) requestInformation.get(ParsedRequestData.SERVICE_TYPE),
					(Object) requestInformation.get("entity"));
			System.out.println(response);
			return response.getBody();
		} catch (UserDoesNotExistException e) {
			e.printStackTrace();
		}
		return null;
	}

}
