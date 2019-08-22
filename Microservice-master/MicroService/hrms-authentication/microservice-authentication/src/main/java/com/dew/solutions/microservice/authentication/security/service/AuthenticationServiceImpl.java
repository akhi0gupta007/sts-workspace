package com.dew.solutions.microservice.authentication.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.authentication.entity.AuthenticationEntity;
import com.dew.solutions.microservice.authentication.entity.Role;
import com.dew.solutions.microservice.authentication.repository.IAuthenticationRepository;
import com.dew.solutions.microservice.authentication.repository.IRoleRepository;
import com.dew.solutions.microservice.authentication.service.IAuthenticationService;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ApplicationErrorCode;
import com.dew.solutions.microservice.config.dto.AuthenticationEntityDto;
import com.dew.solutions.microservice.config.exception.GenericDatabaseException;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;
import com.dew.solutions.microservice.config.util.Utility;

@Service
@Transactional(rollbackFor = Throwable.class)
public class AuthenticationServiceImpl extends AbstractGenericServiceImpl<AuthenticationEntityDto, Long>
		implements IAuthenticationService {

	private IAuthenticationRepository iAuthenticationRepository;

	private IRoleRepository iRoleRepository;

	private Mapper mapper;

	@Autowired
	public AuthenticationServiceImpl(IAuthenticationRepository iAuthenticationRepository,
			IRoleRepository iRoleRepository, Mapper mapper) {
		super(iAuthenticationRepository, mapper, AuthenticationEntityDto.class, AuthenticationEntity.class);
		this.iAuthenticationRepository = iAuthenticationRepository;
		this.iRoleRepository = iRoleRepository;
		this.mapper = mapper;
	}

	@Override
	public boolean createAuthentication(Map<String, Object> requestObject) throws ServiceException {
		try {
			String username = (String) requestObject.get("username");
			String password = Utility.hashPassword((String) requestObject.get("password"));
			@SuppressWarnings("unchecked")
			List<Long> roleIds = ((List<Integer>) requestObject.get("roles")).stream().mapToLong(Integer::longValue)
					.boxed().distinct().collect(Collectors.toList());
			Set<Role> roles = new HashSet<>(iRoleRepository.findAllById(roleIds));

			AuthenticationEntity authenticationEntity = new AuthenticationEntity(username, password, roles);

			AuthenticationEntity entity = iAuthenticationRepository.save(authenticationEntity);
			return entity.getId() != null && entity.getId() > 0 ? true : false;

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new GenericDatabaseException(ApplicationErrorCode.DATABASE_ERROR, e);
		} catch (Exception e) {
			throw new ServiceException(ApplicationErrorCode.SERVER_CALCULATION_ISSUE, e);
		}
	}

}
