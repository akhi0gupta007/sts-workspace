package com.dew.solutions.microservice.config.database.config;

import javax.sql.DataSource;

import lombok.Getter;

public class DatabaseConfig {

	@Getter
	private static DataSource datasource;

	private DatabaseConfig() {

	}

	public DatabaseConfig(DataSource dataSource) {
		this.datasource = dataSource;
	}
}
