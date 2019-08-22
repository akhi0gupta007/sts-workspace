package com.dew.solutions.microservice.authentication.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dew.solutions.microservice.authentication.service.IRoleService;
import com.dew.solutions.microservice.config.dto.RoleDto;
import com.dew.solutions.microservice.config.exception.ServiceException;

@Component
public class BootComponent implements InitializingBean {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String dbResetType;

	@Autowired
	private IRoleService iRoleService;

	@Override
	public void afterPropertiesSet() throws Exception {

		setDefaultRolesInDatabase();
	}

	private void setDefaultRolesInDatabase() throws ServiceException {
		if (dbResetType.equalsIgnoreCase("create")) {
			try {
				iRoleService.saveAll(getDefaultRoles(), null);
			} catch (ServiceException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	private List<RoleDto> getDefaultRoles() {
		List<RoleDto> roles = new ArrayList<>();

		roles.add(new RoleDto("Employee"));
		roles.add(new RoleDto("Supervisor"));
		roles.add(new RoleDto("Team Leader"));
		roles.add(new RoleDto("Project Manager"));
		roles.add(new RoleDto("Business Development Manager"));
		roles.add(new RoleDto("Architect"));
		roles.add(new RoleDto("Director"));
		return roles;
	}

}
