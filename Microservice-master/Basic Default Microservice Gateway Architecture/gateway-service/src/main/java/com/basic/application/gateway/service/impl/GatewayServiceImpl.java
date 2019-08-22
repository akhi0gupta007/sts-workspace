package com.basic.application.gateway.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.application.gateway.proxy.IBasicCrudServiceProxy;
import com.basic.application.gateway.service.IGatewayService;

@Service
public class GatewayServiceImpl implements IGatewayService {

	@Autowired
	private IBasicCrudServiceProxy iBasicCrudServiceProxy;

	@Override
	public Object requestAPIEndpoint(Map<String, ?> requestInformation) {
		return null;
	}

	@Override
	public Object getById(Map<String, ?> requestInformation) throws Throwable {
		return null;
	}

	@Override
	public Object getAll(Map<String, ?> requestInformation) throws Throwable {
		return null;
	}

	@Override
	public Object removeById(Map<String, ?> requestInformation) throws Throwable {
		return null;
	}

	@Override
	public Object saveOrUpdate(Map<String, ?> requestInformation) throws Throwable {
		return null;
	}

}