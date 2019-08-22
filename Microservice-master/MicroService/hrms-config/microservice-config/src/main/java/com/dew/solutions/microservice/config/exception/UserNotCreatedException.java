package com.dew.solutions.microservice.config.exception;

import com.dew.solutions.microservice.config.constants.ApplicationConstants;

public class UserNotCreatedException extends ServiceException {

	public UserNotCreatedException(ServiceException e) {
		super(ApplicationConstants.ApplicationErrorCode.USER_NOT_CREATED, e);
	}

	private static final long serialVersionUID = 728290531279801827L;

}
