package com.dew.solutions.microservice.config.database.config;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class BaseDaoConfig {

	private String tableName;
	private String[] paramNames;
	private Object[] params;
	private Class<?> clazz;
	@Setter
	private Map<String, Object> updateParamAndValues;

	private BaseDaoConfig() {

	}

	public BaseDaoConfig(String tableName, Object[] params, String[] paramNames) {
		this.tableName = tableName;
		this.params = params;
		this.paramNames = paramNames;
	}

}
