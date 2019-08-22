package com.dew.solutions.microservices.professional.info.service;

import com.dew.solutions.microservice.config.dto.CategoryDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface ICategoryService extends IGenericService<CategoryDto, Long> {

	CategoryDto findByCategoryName(String name) throws ServiceException;
}
