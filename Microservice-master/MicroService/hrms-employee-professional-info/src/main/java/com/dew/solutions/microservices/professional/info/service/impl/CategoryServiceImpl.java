package com.dew.solutions.microservices.professional.info.service.impl;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.config.dto.CategoryDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;
import com.dew.solutions.microservices.professional.info.entity.Category;
import com.dew.solutions.microservices.professional.info.repository.ICategoryRepository;
import com.dew.solutions.microservices.professional.info.service.ICategoryService;

@Service
@Transactional(rollbackFor=Throwable.class)
public class CategoryServiceImpl extends AbstractGenericServiceImpl<CategoryDto, Long> implements ICategoryService {

	private ICategoryRepository iCategoryRepository;
	private Mapper mapper;

	public CategoryServiceImpl(ICategoryRepository iCategoryRepository, Mapper mapper) {
		super(iCategoryRepository, mapper, Category.class, CategoryDto.class);
		this.iCategoryRepository = iCategoryRepository;
		this.mapper = mapper;
	}

	@Override
	public CategoryDto findByCategoryName(String name) throws ServiceException {
		// TODO Auto-generated method stub
		return this.mapper.map(iCategoryRepository.findByCategoryName(name), CategoryDto.class);
	}

}
