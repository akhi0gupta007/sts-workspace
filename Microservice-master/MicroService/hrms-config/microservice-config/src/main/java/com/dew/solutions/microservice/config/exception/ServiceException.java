package com.dew.solutions.microservice.config.exception;

import lombok.Getter;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -1898645677784489181L;

	@Getter
	private Integer errorCode;

	@Getter
	private Throwable e;

	@Getter
	private ExceptionCause exceptionCause;

	@SuppressWarnings("unused")
	private ServiceException() {
	}

	public ServiceException(Integer errorCode, Throwable throwable) {
		this.errorCode = errorCode;
		this.e = throwable;
	}
}