package com.dew.solutions.microservice.authentication.security.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.authentication.entity.Role;
import com.dew.solutions.microservice.authentication.repository.IRoleRepository;
import com.dew.solutions.microservice.authentication.service.IRoleService;
import com.dew.solutions.microservice.config.dto.RoleDto;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class RoleServiceImpl extends AbstractGenericServiceImpl<RoleDto, Long> implements IRoleService {

	private IRoleRepository iRoleRepository;

	private Mapper mapper;

	@Autowired
	public RoleServiceImpl(IRoleRepository iRoleRepository, Mapper mapper) {
		super(iRoleRepository, mapper, RoleDto.class, Role.class);
		this.iRoleRepository = iRoleRepository;
		this.mapper = mapper;
	}

}
