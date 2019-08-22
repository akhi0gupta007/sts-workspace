package com.dew.solutions.microservice.common.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.common.entity.Designation;
import com.dew.solutions.microservice.common.repository.IDesignationRepository;
import com.dew.solutions.microservice.common.service.IDesignationService;
import com.dew.solutions.microservice.config.dto.DesignationDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class DesignationServiceImpl extends AbstractGenericServiceImpl<DesignationDto, Long>
		implements IDesignationService {

	private IDesignationRepository iDesignationRepository;

	private Mapper mapper;

	@Autowired
	public DesignationServiceImpl(IDesignationRepository iDesignationRepository, Mapper mapper) {
		super(iDesignationRepository, mapper, Designation.class, DesignationDto.class);
		this.iDesignationRepository = iDesignationRepository;
		this.mapper = mapper;
	}

	@Override
	public DesignationDto findByDesignationName(String name) throws ServiceException {
		return this.mapper.map(iDesignationRepository.findByDesignationName(name), DesignationDto.class);
	}

}
