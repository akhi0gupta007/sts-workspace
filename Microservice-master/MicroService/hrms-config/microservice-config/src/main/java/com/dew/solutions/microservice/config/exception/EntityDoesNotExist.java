package com.dew.solutions.microservice.config.exception;

import com.dew.solutions.microservice.config.constants.ApplicationConstants;

public class EntityDoesNotExist extends ServiceException {

	public EntityDoesNotExist(Throwable throwable) {
		super(ApplicationConstants.ApplicationErrorCode.DATABASE_ENTITY_DOES_NOT_EXIST, throwable);
	}

	private static final long serialVersionUID = 2894028395755652226L;

}
