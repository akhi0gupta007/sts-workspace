package com.dew.solutions.microservice.common.service;

import com.dew.solutions.microservice.common.entity.Designation;
import com.dew.solutions.microservice.config.dto.DesignationDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface IDesignationService extends IGenericService<DesignationDto, Long> {

	public DesignationDto findByDesignationName(String name) throws ServiceException;

}
