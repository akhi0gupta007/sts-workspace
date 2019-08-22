package com.dew.solutions.microservice.config.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationEntityDto extends SuperDto {

	
	private String username;

	private String password;

	private Set<RoleDto> roles = new HashSet<>();

}
