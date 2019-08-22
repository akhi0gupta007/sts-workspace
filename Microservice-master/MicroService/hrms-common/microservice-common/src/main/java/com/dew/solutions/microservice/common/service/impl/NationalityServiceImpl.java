package com.dew.solutions.microservice.common.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.common.entity.Nationality;
import com.dew.solutions.microservice.common.repository.INationalityRepository;
import com.dew.solutions.microservice.common.service.INationalityService;
import com.dew.solutions.microservice.config.dto.NationalityDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class NationalityServiceImpl extends AbstractGenericServiceImpl<NationalityDto, Long>
		implements INationalityService {

	private INationalityRepository iNationalityRepository;

	private Mapper mapper;

	@Autowired
	public NationalityServiceImpl(INationalityRepository iNationalityRepository, Mapper mapper) {
		super(iNationalityRepository, mapper, Nationality.class, NationalityDto.class);
		this.iNationalityRepository = iNationalityRepository;
		this.mapper = mapper;
	}

	@Override
	public Nationality findByNationalityName(String name) throws ServiceException {
		return iNationalityRepository.findByNationalityName(name);
	}

}
