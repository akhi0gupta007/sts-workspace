package com.dew.solutions.microservice.config.database.config;

import java.util.Map.Entry;

import lombok.Getter;

@Getter
public class DatabaseQueryConfig {

	private String insertQuery = "INSERT INTO ${tableName} t ( ${queryParamNames} ) VALUES( ${queryNumbers} );";

	private String updateQuery = "UPDATE ${tableName} t SET ( ${queryUpdateParams} ) WHERE t.id= ?;";

	private String deleteQuery = "DELETE FROM ${tableName} t WHERE t.id= ?;";

	private String selectQuery = "SELECT * FROM ${tableName} t WHERE t.id= ?;";

	private String selectDistinctQuery = "SELECT DISTINCT * FROM ${tableName} t WHERE t.id= ?; ";

	private String selectAllQuery = "SELECT DISTINCT * FROM ${tableName}";

	private DatabaseQueryConfig() {
	}

	public DatabaseQueryConfig(BaseDaoConfig baseDaoConfig) {
		this.insertQuery = updateQueryString(insertQuery, baseDaoConfig);
		this.updateQuery = updateQueryString(updateQuery, baseDaoConfig);
		this.deleteQuery = updateQueryString(deleteQuery, baseDaoConfig);
		this.selectQuery = updateQueryString(selectQuery, baseDaoConfig);
		this.selectDistinctQuery = updateQueryString(selectDistinctQuery, baseDaoConfig);
		this.selectAllQuery = updateQueryString(selectAllQuery, baseDaoConfig);
	}

	private String updateQueryString(String query, BaseDaoConfig baseDaoConfig) {
		this.updateTableName(query, baseDaoConfig);
		this.updateQueryNumbers(query, baseDaoConfig);
		this.updateQueryParamNames(query, baseDaoConfig);
		this.updateQueryString(query, baseDaoConfig);
		this.updateQueryUpdateParams(query, baseDaoConfig);
		return query;
	}

	private String updateTableName(String query, BaseDaoConfig baseDaoConfig) {
		return query.replace("${tableName}", baseDaoConfig.getTableName());
	}

	private String updateQueryParamNames(String query, BaseDaoConfig baseDaoConfig) {
		return query.replace("${queryParamNames}", baseDaoConfig.getParamNames().toString());
	}

	private String updateQueryNumbers(String query, BaseDaoConfig baseDaoConfig) {
		StringBuilder queryNumbers = new StringBuilder();
		int i = 0;
		while (baseDaoConfig.getParamNames().length > i) {
			queryNumbers.append("?");
			i++;
		}
		return query.replace("${queryNumbers}", queryNumbers.toString());
	}

	private String updateQueryUpdateParams(String query, BaseDaoConfig baseDaoConfig) {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, Object> entry : baseDaoConfig.getUpdateParamAndValues().entrySet()) {
			builder.append(entry.getKey() + " = ");
			builder.append(entry.getValue() + ", ");
		}
		return query.replace("${queryUpdateParams}", builder.toString());
	}
}
