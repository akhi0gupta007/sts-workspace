package com.dew.solutions.microservice.config.exception;

import com.dew.solutions.microservice.config.constants.ApplicationConstants;

public class UserDoesNotExistException extends ServiceException {

	public UserDoesNotExistException(Exception e) {
		super(ApplicationConstants.ApplicationErrorCode.USER_DOES_NOT_EXIST, e);
	}

	private static final long serialVersionUID = 6659434480947061896L;

}
