package com.dew.solutions.microservice.common.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.common.entity.State;
import com.dew.solutions.microservice.common.repository.IStateRepository;
import com.dew.solutions.microservice.common.service.IStateService;
import com.dew.solutions.microservice.config.dto.StateDto;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class StateServiceImpl extends AbstractGenericServiceImpl<StateDto, Long> implements IStateService {

	private IStateRepository iStateRepository;

	private Mapper mapper;

	@Autowired
	public StateServiceImpl(IStateRepository iStateRepository, Mapper mapper) {
		super(iStateRepository, mapper, State.class, StateDto.class);
		this.iStateRepository = iStateRepository;
		this.mapper = mapper;
	}

}
