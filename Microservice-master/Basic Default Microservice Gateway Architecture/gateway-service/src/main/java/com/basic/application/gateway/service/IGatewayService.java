package com.basic.application.gateway.service;

import java.util.Map;

public interface IGatewayService {

	public Object saveOrUpdate(Map<String, ?> requestInformation) throws Throwable;

	public Object requestAPIEndpoint(Map<String, ?> requestInformation);

	public Object getById(Map<String, ?> requestInformation) throws Throwable;

	public Object getAll(Map<String, ?> requestInformation) throws Throwable;

	public Object removeById(Map<String, ?> requestInformation) throws Throwable;

}