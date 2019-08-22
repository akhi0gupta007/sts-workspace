package com.dew.solutions.microservice.authentication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Role extends SuperEntity {

	@Getter
	@Setter
	@Column(name = "roleName")
	private String roleName;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role(Integer id) {
		this.setId(id.longValue());
	}

}
