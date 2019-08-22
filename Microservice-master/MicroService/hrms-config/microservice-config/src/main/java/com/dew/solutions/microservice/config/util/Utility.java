package com.dew.solutions.microservice.config.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.dew.solutions.microservice.config.constants.ApplicationConstants;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.Action;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.RequestParams;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ParsedRequestData.SubUrlType;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.response.Response;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Utility {

	public static Response sendSuccessResponse(String message, String key, Object value) {
		Map<String, Object> data = new java.util.HashMap<>();
		data.put(key, value);
		return new Response(ApplicationConstants.HttpResponseCode.OK, message, ApplicationConstants.HttpMessage.SUCCESS,
				data);
	}

	public static Response sendFailureResponse(ServiceException e) {
		Map<String, Object> data = new java.util.HashMap<>();
		data.put("errorResponse", e);
		return new Response(e.getErrorCode(),
				e.getE().getMessage() != null ? e.getE().getMessage() : e.getE().getCause().getMessage(),
				ApplicationConstants.HttpMessage.FAILURE, data);
	}

	public static Response sendImproperParamsResponse(String... missingArgs) {
		Map<String, Object> data = new java.util.HashMap<>();
		data.put("missingParams", missingArgs);
		return new Response(400, "improper params for request", "FAILURE", data);
	}

	public static String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public static Map<String, Object> updateFeignClientResources(HttpServletRequest request)
			throws JsonSyntaxException, JsonIOException, IOException {
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, ?> requestParams = gson.fromJson(request.getReader(), HashMap.class);
		Map<String, Object> feignClientResources = new HashMap<>();

		if (getSubUrl(request.getRequestURI()).equals(SubUrlType.AUTHENTICATION)) {
			feignClientResources.put(RequestParams.USERNAME, requestParams.get(RequestParams.USERNAME));
			feignClientResources.put(RequestParams.PASSWORD, requestParams.get(RequestParams.PASSWORD));
			if (request.getRequestURI().contains("createAuthentication")) {
				@SuppressWarnings("unchecked")
				List<Long> roleIds = ((List<Double>) requestParams.get("roles")).stream().mapToLong(Double::longValue)
						.boxed().distinct().collect(Collectors.toList());
				feignClientResources.put("roles", roleIds);
			}
		} else if (getSubUrl(request.getRequestURI()).equals(SubUrlType.COMMON)
				|| getSubUrl(request.getRequestURI()).equals(SubUrlType.EMPLOYEE)) {
			if (request.getRequestURI().contains("create") || request.getRequestURI().contains("update")
					|| request.getRequestURI().contains("getAll")) {
				feignClientResources.put("object", requestParams.get("object"));
			} else if (getEntityId(request.getRequestURI()) != null) {
				feignClientResources.put("id", getEntityId(request.getRequestURI()));
			}
		}
		if (!getSubUrl(request.getRequestURI()).equals(SubUrlType.AUTHENTICATION))
			feignClientResources.put(ParsedRequestData.ACTION_TYPE, getActionType(request.getRequestURI()));

		return feignClientResources;
	}

	public static String getActionType(String requestURI) {
		String[] urlComponents = requestURI.split("/");
		if (urlComponents.length >= 3) {
			return urlComponents[3];
		}
		return null;
	}

	private static Long getEntityId(String requestURI) {
		String[] urlComponents = requestURI.split("/");
		if (urlComponents.length >= 4) {
			return Long.parseLong(urlComponents[4]);
		}

		return null;
	}

	public static String getSubUrl(String requestURI) {
		String[] urlComponents = requestURI.split("/");
		if (urlComponents.length >= 2) {
			if (ParsedRequestData.SubUrl.LOGIN.equalsIgnoreCase(urlComponents[2])
					|| ParsedRequestData.SubUrl.CREATE_AUTHENTICATION.equalsIgnoreCase(urlComponents[2])) {
				return ParsedRequestData.SubUrlType.AUTHENTICATION;
			} else if (ParsedRequestData.SubUrl.STATE.equalsIgnoreCase(urlComponents[2])
					|| ParsedRequestData.SubUrl.CITY.equalsIgnoreCase(urlComponents[2])
					|| ParsedRequestData.SubUrl.COUNTRY.equalsIgnoreCase(urlComponents[2])
					|| ParsedRequestData.SubUrl.NATIONALITY.equalsIgnoreCase(urlComponents[2])) {
				return ParsedRequestData.SubUrlType.COMMON;
			} else if (ParsedRequestData.SubUrl.EMPLOYEE.equalsIgnoreCase(urlComponents[2])) {
				return ParsedRequestData.SubUrlType.EMPLOYEE;
			}
		}
		return null;
	}

	public static String getServiceType(String requestURI) {
		String[] urlComponents = requestURI.split("/");
		if (urlComponents.length >= 2) {
			return urlComponents[2];
		}
		return null;
	}
}
