package com.dew.solutions.microservice.gateway.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dew.solutions.microservice.config.constants.ApplicationConstants;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ApplicationErrorCode;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.Action;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.RequestParams;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.SubUrlType;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.util.Utility;
import com.dew.solutions.microservice.gateway.proxy.IAuthenticationServiceProxy;
import com.dew.solutions.microservice.gateway.proxy.ICommonServiceProxy;
import com.dew.solutions.microservice.gateway.proxy.IEmployeeGatewayServiceProxy;
import com.dew.solutions.microservice.gateway.service.IGatewayService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

@Controller
@RequestMapping(value = "application")
public class GatewayController {

	private Logger logger = LoggerFactory.getLogger(GatewayController.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IGatewayService iExposedService;

	@PostMapping("/**")
	public @ResponseBody ResponseEntity<?> action(HttpServletRequest request) {
		logger.info("request recieved at exposed controller");
		try {
			Map<String, ?> map = this.createRequestParams(request, applicationContext);
			switch ((String) map.get(ParsedRequestData.SUB_URL)) {
			case ParsedRequestData.SubUrlType.AUTHENTICATION: {
				if (map.get("roles") != null) {
					return ResponseEntity.ok(iExposedService.action(map));
				}
				return (ResponseEntity<?>) iExposedService.action(map);

			}
			case ParsedRequestData.SubUrlType.COMMON:
				switch ((String) map.get(ParsedRequestData.ACTION_TYPE)) {
				case Action.GET:
					return ResponseEntity.ok(iExposedService.getById(map));
				case Action.GET_ALL:
					return ResponseEntity.ok(iExposedService.getAll(map));
				case Action.SAVE_OR_UPDATE:
					return ResponseEntity.ok(iExposedService.saveOrUpdate(map));
				case Action.REMOVE:
					return ResponseEntity.ok(iExposedService.removeById(map));
				}
			case ParsedRequestData.SubUrlType.EMPLOYEE:
				switch ((String) map.get(ParsedRequestData.ACTION_TYPE)) {
				case Action.GET:
					return ResponseEntity.ok(iExposedService.getById(map));
				case Action.GET_ALL:
					return ResponseEntity.ok(iExposedService.getAll(map));
				case Action.SAVE_OR_UPDATE:
					return ResponseEntity.ok(iExposedService.saveOrUpdate(map));
				case Action.REMOVE:
					return ResponseEntity.ok(iExposedService.removeById(map));
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return ResponseEntity
					.ok(Utility.sendImproperParamsResponse(RequestParams.USERNAME, RequestParams.PASSWORD));
		} catch (ServiceException e) {
			e.printStackTrace();
			return ResponseEntity.ok(Utility.sendFailureResponse(e));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(
					Utility.sendFailureResponse(new ServiceException(ApplicationErrorCode.FOREIGN_SERVICE_FAILED, e)));
		}
		return ResponseEntity.ok(Utility.sendImproperParamsResponse(RequestParams.USERNAME, RequestParams.PASSWORD));
	}

	public Map<String, ?> createRequestParams(HttpServletRequest request, ApplicationContext context)
			throws ServiceException {
		Map<String, Object> feignRequestConfig = new HashMap<>();

		feignRequestConfig.put(ParsedRequestData.FEIGN_CLIENT_PROXY,
				updateFeignClientInfo(context, request.getRequestURI()));

		// To resolve the sub URI item to be called from exposed service;
		feignRequestConfig.put(ParsedRequestData.SUB_URL, Utility.getSubUrl(request.getRequestURI()));

		// To resolve general URI for microservices
		if (((String) feignRequestConfig.get(ParsedRequestData.SUB_URL)).equalsIgnoreCase(SubUrlType.COMMON)) {
			feignRequestConfig.put(ParsedRequestData.SERVICE_TYPE, Utility.getServiceType(request.getRequestURI()));
		} else if (((String) feignRequestConfig.get(ParsedRequestData.SUB_URL)).equalsIgnoreCase(SubUrlType.EMPLOYEE)) {
			feignRequestConfig.put(ParsedRequestData.SERVICE_TYPE, Utility.getServiceType(request.getRequestURI()));
		}

		try {
			// Request Params updated in the feign client config to execute feign proxy
			feignRequestConfig.putAll(Utility.updateFeignClientResources(request));

		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
			throw new ServiceException(ApplicationErrorCode.IMPROPER_REQUEST,
					new Exception("Incorrect Request format"));
		}
		if (StringUtils.isNotBlank(request.getHeader(ParsedRequestData.HEADER))) {
			feignRequestConfig.put(ApplicationConstants.ParsedRequestData.RequestParams.AUTHORIZATION_HEADER,
					request.getHeader(ParsedRequestData.HEADER));
		}

		return feignRequestConfig;

	}

	private Object updateFeignClientInfo(ApplicationContext context, String requestURI) {

		String[] urlComponents = requestURI.split("/");
		if (urlComponents.length >= 2) {
			if (Utility.getSubUrl(requestURI).equals(SubUrlType.AUTHENTICATION)) {
				return context.getBean(IAuthenticationServiceProxy.class);
			} else if (Utility.getSubUrl(requestURI).equals(SubUrlType.COMMON)) {
				return context.getBean(ICommonServiceProxy.class);
			} else if (Utility.getSubUrl(requestURI).equals(SubUrlType.EMPLOYEE)) {
				return context.getBean(IEmployeeGatewayServiceProxy.class);
			}

		}
		return null;
	}
}
