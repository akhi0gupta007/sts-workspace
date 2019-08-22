package com.dew.solutions.microservice.config.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Response {

	@JsonProperty("statusCode")
	private int statusCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private String status;

	@JsonProperty("data")
	private Map<String, ?> data = new java.util.HashMap<>();

	@SuppressWarnings("unused")
	private Response() {

	}

	public Response(Integer statusCode, String message, String status, Map<String, ?> data) {
		this.statusCode = statusCode;
		this.message = message;
		this.status = status;
		this.data = data;
	}
}
