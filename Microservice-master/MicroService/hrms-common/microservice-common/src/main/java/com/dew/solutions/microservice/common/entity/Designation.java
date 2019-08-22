package com.dew.solutions.microservice.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Designation extends SuperEntity {

	@Column(name = "name")
	private String designationName;

	@Column(name = "code")
	private String designationCode;

}
