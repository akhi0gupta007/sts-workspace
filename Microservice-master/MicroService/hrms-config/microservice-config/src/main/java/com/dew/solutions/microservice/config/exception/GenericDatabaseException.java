package com.dew.solutions.microservice.config.exception;

public class GenericDatabaseException extends ServiceException {

	private static final long serialVersionUID = -1004709322673395444L;

	public GenericDatabaseException(Integer errorCode, Throwable throwable) {
		super(errorCode, throwable);
	}


}
