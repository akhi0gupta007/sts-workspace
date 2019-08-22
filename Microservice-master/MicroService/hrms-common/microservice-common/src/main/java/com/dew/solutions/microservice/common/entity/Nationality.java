package com.dew.solutions.microservice.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dew.solutions.microservice.config.entity.SuperEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Nationality extends SuperEntity {

	@Column(name = "name")
	private String nationalityName;

	@Column(length = 2, name = "code")
	private String nationCode;

}
