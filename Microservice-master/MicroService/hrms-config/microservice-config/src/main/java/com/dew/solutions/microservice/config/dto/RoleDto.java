package com.dew.solutions.microservice.config.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto extends SuperDto {

	@Column(name = "roleName")
	private String roleName;

	public RoleDto(String roleName) {
		this.roleName = roleName;
	}

	public RoleDto(Integer id) {
		this.setId(id.longValue());
	}



}
